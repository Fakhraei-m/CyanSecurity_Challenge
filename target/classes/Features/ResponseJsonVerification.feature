
@Problem3
Feature: Title of your feature
  I want to use this template for my feature file

	@Rest-Assured
	Scenario: Send GET request for Users and check for an specific user in response

  	Given I send GET request to "https://jsonplaceholder.typicode.com/users"
    Then I should receive response that contains
    |	Fields			|	Values										|
    |	status code	|	200												|
    |	name				|	Nicholas Runolfsdottir V	|
    
  @tag1
  Scenario: Vrify the address of an specific user
  
    Given I send GET request to "https://jsonplaceholder.typicode.com/users"
    When I receive response that contains
    |	Fields			|	Values		|
    |	status code	|	200				|
    |	name				|	Nicholas Runolfsdottir V	|
    Then the user address should be
    |	Fields		|	Values							|
    |	street		|	Ellsworth Summit		|
    |	suite			|	Suite 729						|
    |	city			|	Aliyaview						|
    |	zipcode		|	45169								|
    |	lat				|	-14.3990						|
    |	lng				|	-120.7677						|  
