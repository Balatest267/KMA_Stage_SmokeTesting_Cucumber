Feature: Login Action


#With Examples keyword
Scenario Outline: Successful Login with valid credentials  

Given user is on KIA web portal Landing Page       					
And page title is Kia Owners Portal  
And user clicks the Sign in button							
When user enter the "<username>" and "<password>"				
And user clicks the login button
Then user is on welcome page
Then user pick the vehicle 
Then user is on dashboard page
Then fetch the name of the vehicle	


#Then get the status of the door
#Then user clicks the lockUnlock option
#Then user clicks the remoteClimate option
#Given user is on Remote Section
#When user perform Remote Door features 
#And user perform Remote Climate  features
#Then status of the Remote Door and Climate status
#Given user is on Schedules Section 

#Given user is on Locations Section
#Given user is on Maintenance Section
#Given user is on MyCarZone Section
#Then user find the vehicle location
#Then capture the alert message
#This is the test 	
Then close the browser	


Examples:
	
		|     username				  | password  |
	    |  testen15@mailinator.com    | Password1 |
	  
	
	   