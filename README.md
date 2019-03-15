# twp-cjbucker-jwhoward2
Title: Wiki Revision Grab

This Project is an attempt to parse JSON data retrieved from Wikipedia in order to build a compiled list that will
dispay usernames updating a particular wikipedia URL.

PreRequisites For Operation: Java 8 or higher

Installation:
Inside pom.xml, then inside build. Change source and target to your jdk version. The Main method of this build is labeled
as UserInterface.

Testing:
Running the test involves marking the directory tests as the test sources folder as the test sources directory and the
java directory as the general sources root and selecting run all tests.

Test breakdown:
The tests checkIfWikiDoesntExistTest and WikiExistsTest check to ensure that there is a valid wiki url inputted into the
 Url bar. The tests InternetDoesntExistTest and InternetDoesExistTest test to ensure that the internet connection is active.

Built with:
Java 8
Java 9
Maven: Dependency management
JSON
GSON

UI done with:
JavaFX

Supressed Warnings:
Supressed three warnings in the Revisions Class with "WeakerAccess" due to a private package warning that had bearing on the codes functionality.
Supressed one warning in UserInterface on the TableView method with "Unchecked" due the ide's desire to convert it to a variable

Authors:
Chris Bucker,
John Howard

