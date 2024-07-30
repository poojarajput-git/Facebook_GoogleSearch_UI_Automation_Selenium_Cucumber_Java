Feature: Facebook Login

  Scenario: Successful login with valid credentials
    Given I am on the Facebook login page
    When I enter the email and password
    Then I click on the login button
