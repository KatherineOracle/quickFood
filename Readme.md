# QuickFood - it became a JavaFX experiment!

Thank you for reviewing my work - again. 

Following an interview and secondary review by HyperionDev Technical Quality Specialist, Ronald Munodawafa, 
it was assertained that my work was my own.

Furthermore it was recommended by Ronald that I:
1 Scribe this readme file
2 use Maven to package my project 

## Installation

Install Maven from https://maven.apache.org/download.cgi

Follow the installation instructions https://maven.apache.org/install.html 

Thereafter, navigate to the root of this project and run this command:
`mvn clean javafx:run` 

Fingers crossed all goes well and the GUI launches!

---

## Key aspects to review in terms of project brief:

Extend the program that you have written in the previous Capstone Project so that this program also:

1. Outputs a text file that shows a list of the customer’s names and order numbers in alphabetical order. 
2. Outputs a text file that shows a list of the customer’s names grouped by location.
For both, click through to the "Administrator" scene in the GUI, related code updates can be found in:
    - quickfood\src\main\java\kv\hyperiondev\java\quickfood\AdminToolsUIController.java
    - quickfood\src\main\java\kv\hyperiondev\java\quickfood\InvoiceRecords.java
    - quickfood\src\main\java\kv\hyperiondev\java\quickfood\InvoiceRecord.java
    - quickfood\src\main\java\kv\hyperiondev\java\quickfood\Invoice.java (line 88)

3. Updates the original drivers.txt file to add to their load if they have been matched with a customer. See:
    - quickfood\src\main\java\kv\hyperiondev\java\quickfood\Driver.java (line 34)
    - quickfood\src\main\java\kv\hyperiondev\java\quickfood\Drivers.java (line 105 and 108)

Make use of:
    - Exception handling with try catch blocks (at least two)
    - code debugged
    - good indentation
    - strict naming conventions
    - refactoring    

---

## Thank-you

I appreciate you taking the time to review my project and look forward to further insights to learn and improve. 