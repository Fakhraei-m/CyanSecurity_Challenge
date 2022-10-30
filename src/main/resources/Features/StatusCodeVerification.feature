
@Problem2 @API
Feature: Verifying Status codes for "http://the-internet.herokuapp.com" using Rest-Assured lib

@Rest-Assured
Scenario: Send GET request to "http://the-internet.herokuapp.com/status_codes/200" and check the status code
  	
  	Given I send GET request to "http://the-internet.herokuapp.com" as following
    |	Fields			|	Values								|
    |	path param	|	/status_codes/200			|
    Then I should receive response as following
    |	Fields			|	Values		|
    |	status code	|	200				|

@Rest-Assured
    Scenario: Send GET request to "http://the-internet.herokuapp.com/status_codes/404" and check the status code

  	Given I send GET request to "http://the-internet.herokuapp.com" as following
    |	Fields			|	Values								|
    |	path param	|	/status_codes/404			|
    Then I should receive response as following
    |	Fields			|	Values		|
    |	status code	|	404				|

@Rest-Assured    
    Scenario: Send GET request to "http://the-internet.herokuapp.com/status_codes/500" and check the status code

  	Given I send GET request to "http://the-internet.herokuapp.com" as following
    |	Fields			|	Values								|
    |	path param	|	/status_codes/500			|
    Then I should receive response as following
    |	Fields			|	Values		|
    |	status code	|	500				|

@HttpUrl
Scenario: Send GET request to "http://the-internet.herokuapp.com/status_codes/301" and check the status code

  	Given I send "GET" request to "http://the-internet.herokuapp.com/status_codes/301"
    Then I should receive response with status code "301"
