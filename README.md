# Petstore_Test-Automation-projects
Test Automation projects for Petstore API

Testing Framework:
Selected CRUD operations for Smoke test:

  POST /pet - Add a new pet to the store
  GET - /pet/{petId}  - Find pet by ID
  PUT /pet - Update an existing pet
  DELETE /pet/{petId}  - Deletes a pet

For the given Petsore API, the best way of framework for testing is to create a flow.

  1st Step - Add a new pet to the store (POST method)
  2nd Step - Retrieve the added pet to validate whether the pet is added properly or not. 
		         This step performs both testing of GET call and also validation of 1st Step POST call.
			
  3rd Step - Update the existing pet with some details (PUT Method)
  4th Step - Retrieve the edited pet to validate whether the pet's details are edited properly or not. 
		         This step performs both testing of GET call and also validation of 3rd Step PUT call.
			
  5th Step - Delete the created pet (DELETE method)
  6th Step - Retrieve the deleted pet to validate whether the pet's details are deleted properly or not. 
		         This step performs both testing of GET call and also validation of 5th Step DELETE call.


To execute the SoapUI project :
Browse : https://github.com/pradeepkumar22/Petstore_Test-Automation-projects/tree/master/Task/SoapUI%20Project

To execute the Postman project :
Browse : https://github.com/pradeepkumar22/Petstore_Test-Automation-projects/tree/master/Task/Postman%20Project
