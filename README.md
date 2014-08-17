CS3213-HW-A1
============

CS3213 Homework 1

### Requirements
Assignment 1: KWIC-KWAC-KWOC
For this assignment :
You will implement a KWIC (Key Word In Context) index system. You can refer to the readings 
available in the IVLE workbin/Readings folder. 
1. "On the criteria to be used in decomposing systems into modules" by D L Parnas
2. "An Introduction to Software Architecture" by David Garlan and Mary Shaw
Choose any of the architectural designs mentioned in the case study-1 of Reading-2. 
Alternatively, you can modify and come up with a new design. 
Implement your chosen or modified design in Java. 
Submit the code and a short report on the architectural design you follow for the 
implementation.
Also, refer to the requirements and submission instructions given below.

* Functional
(Grading will be based on how close the implementation is to the specified design)
KWIC (Key Word In Context) index system provides a search mechanism for information in a 
long list of lines, such as movie titles. Given a list of titles and a list of ``words to ignore'', you 
are to write a program that generates a KWIC (Key Word In Context) index of the titles. In a 
KWIC-index, a title is listed once for each keyword that occurs in the title. The keyword cannot 
be in "words to ignore" and the KWIC-index is alphabetized by keyword.
For each input title, it shall be “circularly shifted” exhaustively by removing the first word and 
appending it at the end of the line to create a set of circularly shifted lines. The first word (not 
including "words to ignore") will be the keyword. The system shall output on the screen a listing 
of the circularly shifted lines for all input titles in ascending alphabetical order. Display the 
keyword in upper case and the rest in lower case.
For example, if the "words to ignore" are ["is", "the", "of", "and", "as", "a", "after"] and the 
titles are ["The Day after Tomorrow", "Fast and Furious", "Man of Steel"], the output should be 
as below.
Day after Tomorrow the
Fast and Furious
Furious Fast and
Man of Steel
Steel Man of
Tomorrow the Day After

* Non-functional
The index system you implement should be:
User friendly - the system user interface should be easy for users to use the system
Response time - the system should respond to user's query in a reasonable time e.g. 
comparable to the common search engine such as Yahoo.
Extendable - new functions can be added to the system easily without any major 
changes to the design of the system. 
(You may add more non functional requirements. Mention them in your design document.)
