# Stackoverflow Users Application

## Description of project
Using the stackoverflow.com api documented at: https://api.stackexchange.com/docs retrieve
the list of stack overflow users meeting the following criteria:
- Are located in Romania or Moldova
- Have a reputation of min 223 points.
- Answered min 1 question
- Have the tags: "java",".net","docker" or "C#"

## Description of my solution
To reduce the load on the **Stackoverflow** server when fetching users, 
it was decided to get the first *10* pages of *100* elements on each page. 
Ultimately, after applying all of the above search criteria, 9 users were received.</br>
To get more users, you can change the number of pages in this
[class](/src/main/java/org/danylo/utils/StackoverflowUsersReceivingFacade.java).