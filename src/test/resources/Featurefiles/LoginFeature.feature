@UI_Test
Feature: User Login

@Tc_Login_001
Scenario: Validate user able to login successfully

Given the user login with 'valid' credentials
Then user update the password successfully
Then logout from the application
When the user login with 'updated' credentials
And validate the user is on the home page
Then logout from the application
