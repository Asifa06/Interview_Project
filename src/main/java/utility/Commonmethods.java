package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


import io.qameta.allure.Allure;

public class Commonmethods {
    
    public static WebDriver driver;
    
    

    /**
     * 
     * @param element - locator of element which mentioned in object repo
     * @return - expected locator
     * @throws IOException 
     * @throws DatabindException 
     * @throws StreamReadException 
     */
    public static By getLocator(String section, String element) throws IOException {
        // Load the JSON file
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/Object_Properties/objectrepo.json");

        // Create ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        // Convert JSON to Map<String, Map<String, String>>
        Map<String, Map<String, String>> map = mapper.readValue(file, new TypeReference<>() {});
        
        // Get the specific section (like "loginPage" or "homepage")
        Map<String, String> locators = map.get(section);
        if (locators == null) {
            throw new IllegalArgumentException("Section not found: " + section);
        }

        // Get the locator string
        String value = locators.get(element);
        if (value == null || !value.contains("|")) {
            throw new IllegalArgumentException("Invalid locator format for element: " + element + " in section: " + section);
        }

        // Split locator type and locator value
        String[] parts = value.split("\\|", 2);
        String type = parts[0].trim();
        String locatorValue = parts[1].trim();

        return switch (type.toLowerCase()) {
            case "id" -> By.id(locatorValue);
            case "name" -> By.name(locatorValue);
            case "xpath" -> By.xpath(locatorValue);
            case "css" -> By.cssSelector(locatorValue);
            case "class" -> By.className(locatorValue);
            case "tag" -> By.tagName(locatorValue);
            case "linktext" -> By.linkText(locatorValue);
            case "partiallinktext" -> By.partialLinkText(locatorValue);
            default -> throw new IllegalArgumentException("Unsupported locator type: " + type);
        };
    }

    private static Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Configuration/configuration.properties")) {
            
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load credentials");
        }
    }

    public static String getCredential(String key) {
        return properties.getProperty(key);
    }
    
    
    public static void switchtowindow(WebDriver driver, String windowtitle) {
        try {
            Set<String> windowHandles = driver.getWindowHandles();
            
            for (String handle : windowHandles) {
                driver.switchTo().window(handle);
                if (driver.getTitle().equals(windowtitle)) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        // Take screenshot and store it as a file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        // Define the destination path for the screenshot
        String destinationPath = "target/allure-results/screenshots/" + screenshotName + ".png";
        
        try {
            // Save the screenshot to the desired path
            FileUtils.copyFile(screenshot, new File(destinationPath));
            
            // Attach the screenshot to the Allure report
            Allure.addAttachment(screenshotName, "image/png", new FileInputStream(screenshot), ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    }