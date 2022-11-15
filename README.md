Format (to be removed):
What is it about
How to compile
How to run

# Introduction
This is an inventory management system. It is designed to:
1. Monitor stock levels on various materials and products
2. Mark down positions of various materials and products within the storage facility
3. Collect data on stock level changes, supply times and defective batches of supply
4. Plan ahead for a schedule to order new batch of materials based on consumption and lead time
5. Cooperate with management personnel decisions to alter ordering strategy in response to external factors such as drop in supply cost or difficulty getting supplied in the foreseeable future
6. Alert the responsible individuals when stock levels are not expected to sustain normal operations of the company for an adjustable number of days ahead

(How to run)

(How to compile)

# public_workspace
This is the directory with folders holding each component.

# StorageMap
It handles function point 2 as the locator of stock within the inventory. It has 4 main components:
- list(). 

# Stopper (Alert System)
The stopper or the alert system used in the inventory consists of three clases which are "Application", "Material", and "MaterialList".

Application class is the class that has all the alert system functions are combined to be executed when the feature is run by the user. Inside of the class, there are three functions. The first, the crucial one for the execution of the feature, is called "runAPP". It has all the functions written in other classes to run the alert system properly. The second function inside the Application class is called as "materialAdd". As it can be guessed from its name, it does add the names, amounts, maximum and minimum values of each material stored in the inventory. The third, and the final function inside this class, is named as "importExport". In this function, it performs either import or export process depending on the user's answers to the questions on the console. Questions helps to decide which material and amount to be imported or exported. The code functions with switch case. 


Material class is where the material is added. In other words, its constructor method is used as a materials data input panel. Due to this reason, it also consists of getters and setters. In addition, this is where the limits are chceked by the user's imputs to the console with "importAmount" and "exportAmount" functions. If the limits are exceeded, it executes execptions to show that limits are passed. One feature of the "exportAmount" function is that it bumps up a warning message if the amount of a material drops below the mimimum limit.  

As for the final class of the stopper feature, MaterialList class, it stores the materials as an arraylist made inside this class. With this informtaion, it has functions related to arraylist like: adding material, getting material list to see which elements are stored inside, or a different way to print the elements inside the arraylist using "toString" function.

# Functions In Software

ALERT SYSTEM FUNCTIONS THAT IMPLEMENTED TO MAKE THE CODE RUN:

public String toString():it returns the elements to the console in a different format.
  
public void checkMinAmount(): checks if the amount left is below minStock.
  
public void giveWarning(): It gives the warning the user if the stock is below minStock.
  
public void runApp() throws LimitExceededException: it is the main function of the alert.
    
private void importExport(String appType, int materialIndex, int amount) throws LimitExceededException: it does the export and import applications based on the users choices.

These functions were implemented to improve the quality of the user interface. In other words, to increase the usability of the software. If these features were not implemented, it would be a lot harder fot the user to understand and to use the program.

# Base Plan

The basic plan and layout of the whole system. It shows how the system run.

public void take(): This function is used to take items from the warehouse.

public void returned(): This function is used to restock items.

public int getPrice(): This return the price of an item.

void checkOut(String iname): Check the name of the input item name and match with the corresponding function.

public void receivePrice(): Used to enter the price of an item.

public void listInventory(): Used to show the list of the inventory.

