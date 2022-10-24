package ui;

import locations.Office;
import locations.Storage;
import locations.Warehouse;

import java.util.Scanner;

public class InventoryManagementSystem {

    Scanner textInput;
    int i;
    boolean success;

    public InventoryManagementSystem() {
        textInput = new Scanner(System.in);
        processOperations();
    }

    public void processOperations() {
        String operation;
        Storage item;

        while (true) {
            i = 0;
            System.out.println("What's your command? (store, take, find, quit)");
            operation = textInput.nextLine();
            System.out.println("You chose: " + operation);

            if (operation.equals("quit")) {
                break;
            }

            if (operation.equals("store")){
                i++;
                System.out.println("Where do you want to store this item? (office or warehouse)");
                String location = textInput.nextLine();

                if (location.equals("office")) {
                    item = new Office();
                    item.store();
                }
                if (location.equals("warehouse")) {
                    item = new Warehouse();
                    item.store();
                }
                else {
                    System.out.println("Sorry I couldn't locate the storage facility you're looking for.");
                }
            }

            if (operation.equals("take")){
                i++;

            }

            if (operation.equals("find")){
                i++;
                System.out.println("Please enter the barcode of the item you want to take.");
                String barcode = textInput.nextLine();
                item = new Office();
                success = item.find("Office", barcode);
                if (success == true) {
                    item.locate("Office", barcode);
                }
                if (success == false) {
                    item = new Warehouse();
                    success = item.find("Warehouse", barcode);
                }
                if (success == true) {
                    item.locate("Warehouse", barcode);
                }
                if (success == false) {
                    System.out.println("Barcode: " + barcode + " could not be found.");
                }
            }

            if (i == 0) {
                System.out.println("Sorry I don't understand your command");
            }
        }

    }

    public static void main(String[] args) {
        new InventoryManagementSystem();
    }
}
