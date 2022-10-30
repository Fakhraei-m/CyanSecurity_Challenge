
@Problem1 @UI
Feature: Login feature
  I want to use this template for my feature file

  @Positive
  Scenario: Test Login functionality with VALID data
		Given I am in login page
    When I enter "tomsmith" as username and "SuperSecretPassword!" as password
    And I click on login button
    Then I should be redirected to "secure" page
    And I should see the message "You logged into a secure area!"
    
  @Positive
  Scenario: Test Logout functionality
		Given I am logged in to secure page
    When I click on logout button
    Then I should be redirected to "login" page
    And I should see the message "You logged out of the secure area!"
    
 	@Negative
  Scenario Outline: Test Login functionality with INVALID data
    Given I am in login page
    When I enter <username> as username and <password> as password
    And I click on login button
    Then I should be redirected to "login" page
    And I should see the message <message>

    Examples: 
      | username		|	password								|								message				|
      | ""  				| 		""									|	"Your username is invalid!"	|
      |	"tomsmith"	|			""									|	"Your password is invalid!"	|
      |	"tomsmith"	| "!drowssaPterceSrepuS"	|	"Your password is invalid!"	|
      |	"htimsmot"	|	"SuperSecretPassword!"	|	"Your username is invalid!"	|
      |	"tomsmith"	|	"supersecretpassword!"	|	"Your password is invalid!"	|
