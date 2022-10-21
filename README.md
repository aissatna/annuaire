# Annuaire
Rest api (Java Spring Boot) for a person directory management 
---------
Database
--------
SGBD = postgresql  
database name = annuaire  
username = annuaire  
password = admin 

You can change these settings in the application.properties file

------------
Info
-----------
The application start with three person instances, check PersonConfig file 

-----------
Requests
----------

Get http://localhost:8070/annuaire/entree  --> GetAllPersons

Get http://localhost:8070/annuaire/entree/1  --> GetPerson with id=1 

Delete http://localhost:8070/annuaire/entree/1 --> delete person with id=1

Put http://localhost:8070/annuaire/entree/1?name=john&surname=john&phone=1233&city=paris --> update person with id = 1

Post http://localhost:8070/annuaire/entree --> add new person with data in the body request  
{  
 "name" : "Lee",   
"surname":"Jet",  
"phone":"123456789",   
"city":"Pekin"     
}
