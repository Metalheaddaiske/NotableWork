Steven Woolf
Auburn University
COMP 3700: Software Modeling and Design
Fall 2020

Grocery Store Database App README:

This is a Java GUI application that can display the data in an SQL table that has been requested by the user. The user must enter the name of the desired table
and the program will retrieve the data in that table from a database and display it in a GUI text field. The SQL database for this application contains three tables: customers, products, 
and purchases. These tables contain data relevant to the business of a fictional grocery store. 

The purpose of this project is to practice coding a Java GUI application and learn how to gather data from an SQL database using Java.

COMPILATION:
----------------------------------------------------------------------------------------------------------------------------------------------------------------------
Compilation of this program will require downloading and enabling the JDBC SQLite Java library in the development environment used to compile this program.
It will not work without this library. 

I was not able to run this program in a linux terminal as displaying a GUI from a linux terminal requires another download. I would recommend using an IDE
in windows to run this program. 

I have included PDF images showing the working GUI in case an IDE is not avalaible.

USE:
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Type in the name of the desired table in the text box labelled "Enter Table name". Then, click the button labelled "Request Table Contents" to view
the contents of the table.   

Since the only three tables in the database are "customers", "products", and "purchases", it will only display a table when one of these three titles is typed
into the table name field. Otherwise, it will display "Table not found".

TECHNOLOGY:
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
This project employs the Java Swing library, which provides code for displaying a GUI. It also uses the JDBC SQLite library, which permits the execution of SQL
code within Java and allows a Java program to retrieve data from an SQL database.

This project was created using JetBrains IntelliJ Idea.