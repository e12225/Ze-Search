Ze-Search Application Exercising Guide
--------------------------------------

1.) This search application is implemented using Java 8.

2.) There are three external libraries being used in the implementation. They are,

			* json-simple-1.1.1.jar
			* gson-2.6.2.jar
			* junit-4.10.jar
	
	The above mentioned .jar files are located in "Ze-Search\libraries" folder. Therefore, make sure to include those libraries into the application
	running environment, before compiling and running the code.
	
	Ex: If you are using IntelliJ, when the project is opened, navigate to File > Project Structure > Project Settings > Modules > click the Dependencies tab.
		Then, click the + button, select the 'JARs or Directories' option and select the jar files. Apply the changes and click OK.
	
3.) Compile (Ctrl + Shift + F9) and run (Ctrl + Shift + F10) the application.

    Class compiling order : i. DataFilter.java
						   ii. DataLoading.java
					      iii. Core.java 

4.) You'll be shown a welcoming message. Below that, you'll be first asking to enter the location to the 'users.json' file. All three JSON files 
   (uers.json, tickets.json and organizations.json) are located in "Ze-Search\data-sources" folder. Therefore, enter the FULL file path as the command line input.
   
NOTE: The file path String should be ended with a '\'

5.) Likewise, enter the file locations String s of 'organizations.json' and 'tickets.json' as well.

6.) After entering the valid file paths for all the json files, you'll e asked to enter a category out of 'Users', 'Organizations' and 'Tickets', in order to
	proceed the search.
	
7.) There, enter one category as per your choice.
	Ex : Users
	
8.) Then, you'll be asked to enter the name of the field, on which you want to search the category.
	Ex: alias
	
	This means, you are going to search the user objects in the 'users.json' file, depending on the value of 'alias' field.

9.) Then, you have to enter the value of the field, so you can filter the objects using that value.
	Ex: Miss Coffey
	
	This means, you are going to search the user objects in the 'users.json' file, where the value of 'alias' field is 'Miss Coffey'(i.e, alias = "Miss Coffey").
	
10.) Then the search results will be displayed in the command line and execution process will be finished.

11.) There will be a set of warning messages displaying in certain scenarios.
	 Ex: 
	 * Warning message, when the file paths are not entered
	 * File not found error
	 * JSON parse exception
	 * Warning message, when an invalid/empty category is entered
	 * Warning message, when the field is empty
	 * Warning message, when the json files are empty
	 
	



	