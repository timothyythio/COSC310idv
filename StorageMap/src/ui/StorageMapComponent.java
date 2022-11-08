package ui;

import locations.Office;
import locations.Storage;
import locations.Warehouse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class StorageMapComponent {

    List<String> lines;
    PrintWriter writer;

    Scanner textInput;
    Storage item;
    String location;
    String response;
    boolean success;
    boolean i = false;
    int g;

    public static void main(String[] args) {
        new StorageMapComponent();
    }
    public StorageMapComponent() {
        textInput = new Scanner(System.in);
        processOperations();
    }

    public void processOperations() {
        String operation;

        while (true) {
            System.out.println("What's your command? (list, store, find, take, quit)");
            operation = textInput.nextLine();
            System.out.println("You chose: " + operation);

            if (operation.equals("quit")) {
                break;
            }

            else if (operation.equals("list")) {
                list();
            }
            else if (operation.equals("store")){
                store();
            }

            else if (operation.equals("find")){
                find();
            }

            else if (operation.equals("take")){
                take();
            }

            else {
                System.out.println("Sorry I don't understand your command");
            }
        }

    }

    public void list() {
        System.out.println("Which storage facility would you like to check? (office or warehouse)");
        String location = textInput.nextLine();

        if (location.equals("office")) {
            item = new Office();
            item.list();
        }
        else if (location.equals("warehouse")) {
            item = new Warehouse();
            item.list();
        }
        else {
            System.out.println("Sorry I couldn't locate the storage facility you're looking for.");
        }
    }
    private void store() {
        System.out.println("Please enter the barcode of the item.");
        String barcode = textInput.nextLine();

        item = new Office();
        success = item.find("Office", barcode);
        location = "Office";
        if (!success) {
            item = new Warehouse();
            success = item.find("Warehouse", barcode);
            location = "Warehouse";
        }
        if (success) {
            System.out.println("Matching barcode has been found in " + location + ", proceed to add? (Y for Yes or N for No)");
            response = textInput.nextLine();
            if (response.equals("Y")) {
                g = 1;
            }
            else if (response.equals("N")) {
                g = 0;
            }
            else {
                System.out.println("Sorry your input cannot be understood.");
            }
        }
        else {
            g = 1;
        }

        if (g == 1) {
            System.out.println("Where do you want to store this item? (office or warehouse)");
            String location = textInput.nextLine();

            if (location.equals("office")) {
                item = new Office();
                item.store(barcode);
            }
            else if (location.equals("warehouse")) {
                item = new Warehouse();
                item.store(barcode);
            }
            else {
                System.out.println("Sorry I couldn't locate the storage facility you're looking for.");
            }
        }

    }
    private void find() {
        System.out.println("Please enter the barcode of the item you want to find");
        String barcode = textInput.nextLine();

        item = new Office();
        success = item.find("Office", barcode);
        if (success) {
            item.locate("Office", barcode);
            i = true;
        }
        item = new Warehouse();
        success = item.find("Warehouse", barcode);
        if (success) {
            item.locate("Warehouse", barcode);
            i = true;
        }
        if (!i) {
            System.out.println("Barcode: " + barcode + " could not be found.");
        }
    }

    private void take() {
        System.out.println("Please enter the barcode of the item you want to find");
        String barcode = textInput.nextLine();

        item = new Office();
        success = item.find("Office", barcode);
        if (success) {
            item.take("Office", barcode);
        }
        else {
            item = new Warehouse();
            success = item.find("Warehouse", barcode);
            if (success) {
                item.take("Warehouse", barcode);
            }
            else {
                System.out.println("Barcode: " + barcode + " could not be found.");
            }
        }
    }

}
