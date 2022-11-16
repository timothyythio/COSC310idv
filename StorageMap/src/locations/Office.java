package locations;

import fileRW.FileReaderWriter;

import java.io.IOException;
import java.util.Scanner;

public class Office implements Storage {

    boolean success;
    String barcode;
    String location;
    FileReaderWriter fileData;
    Scanner textInput = new Scanner(System.in);

    public void list() {
        fileData = new FileReaderWriter();
        try {
            fileData.listInventory("Office");
        } catch (IOException e) {
            System.out.println("Failed to read data from file.");
        }
    }

    //Format of spots: name
    public void store(String barcode){
        System.out.println("Please enter the name of the storage space");
        location = textInput.nextLine();

        fileData = new FileReaderWriter();
        String spot = barcode + " " + location;
        System.out.println("Data {" + spot + "} will now be added to file");
        try {
            fileData.storeIntoInventory("Office", spot);
        } catch (IOException e) {
            System.out.println("Failed to write data to file.");
        }

    }
    public boolean find(String storage, String barcode){
        fileData = new FileReaderWriter();
        try {
            success = fileData.findInInventory(storage, barcode);
        } catch (IOException e) {
            System.out.println("Failed to use finder method");
        }
        return success;
    }

    public void locate(String storage, String barcode){
        fileData = new FileReaderWriter();
        try {
            fileData.locateInInventory(storage, barcode);
        } catch (IOException e) {
            System.out.println("Failed to use locator method");
        }
    }

    public void take(String storage, String barcode){
        fileData = new FileReaderWriter();
        try {
            fileData.takeFromInventory(storage, barcode);
        } catch (IOException e) {
            System.out.println("Failed to use taker method");
        }
    }
}
