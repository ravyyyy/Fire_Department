Steps for running the application:

1) Open IntelliJ.
2) Click the 'Open' button.
3) Choose the project's folder.
4) Open pgAdmin4.
5) Create a new database.
6) Right click on the new database and select 'Restore'.
7) Choose the file called 'FireDepartmentDBBackup'.
8) Go back to IntelliJ and select the application.properties file.
9) Update the code with your username and password.
10) Run the IntelliJ application.
11) Open Postman and create a new request.
12) In order to create a GET request, you must select the GET method and add the URL: localhost:8080/api/firestations (for example).
13) Click the 'Send' button and you should receive a JSON code down below with the data from the table.
14) In order to create a POST request, you must select the POST method and add the URL: localhost:8080/api/firestations (for example).
14) Then select 'Body', check 'raw' and select 'JSON'.
15) Now, write inside the specific body for the object that you wish to add like this:
{
	"attribute_1": value_1,
	"attribute_2": value_2,
	...
	"attribute_n": value_n
}
16) Click the 'Send' button.
17) In order to create a PUT request, you must select the PUT method and add the URL: localhost:8080/api/firestations/ (for example) 
followed by the id of the object you wish to edit.
18) The 'Body', check 'raw' and select 'JSON'.
19) Now, write inside the specific body for the object that you wish to edit like this:
{
	"attribute_1": value_1,
	"attribute_2": value_2,
	...
	"attribute_n": value_n
}
17) Click the 'Send button'.
18) In order to create a DELETE request, you must select the DELETE method and add the URL: localhost:8080/api/firestations (for example).
This will delete all the objects from that specific table.
If you wish to delete a specific object, use this URL: localhost:8080/api/firestations/ (for example) followed by the id of the object you wish to delete.

Utilized software versions:
