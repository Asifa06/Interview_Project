QA Interview Project – Movie Reviews Application
📌 Overview
This project is part of the KMBAL QA Engineer pre-interview test. It is a test automation framework built to validate the functionalities of a Movie Reviews application. The tests cover UI layers using BDD principles.

🚀 Tech Stack Used
Java 23
Cucumber 6.7.0
Selenium 4.27.0
Allure Report 2.32.2
Maven
JUnit 4
WebDriverManager

✅ Test Scenarios
UI End-to-End Scenarios:
Login with valid credentials
Update password after login
User login with updated password
Logout functionality

🧪 How to Run the Tests
Prerequisites:
Java (JDK 23)
Maven
Allure CLI installed globally (npm install -g allure-commandline)
Steps to Execute:
# Clone the project
git clone https://github.com/Asifa06/QA_Interview_Project.git
cd QA_Interview_Project

# Run tests
mvn clean test
or run the TestRunner.java file

To open the report allure serve allure-results 
