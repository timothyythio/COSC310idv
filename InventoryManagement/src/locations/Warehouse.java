package locations;

import fileRW.FileReaderWriter;

import java.io.IOException;
import java.util.Scanner;

public class Warehouse implements Storage {
    int x;
    int y;
    int z;
    int i = 3;
    boolean success;
    String barcode;
    String location;
    FileReaderWriter fileData;
    Scanner textInput = new Scanner(System.in);

    //Format of spots: x-coordinate, y-coordinate, z-coordinate
    public void store(){
        System.out.println("Please enter the barcode of the item");
        barcode = textInput.nextLine();

        System.out.println("Please enter the x coordinate of the storage space");
        x = textInput.nextInt();
        System.out.println("Please enter the y coordinate of the storage space");
        y = textInput.nextInt();
        System.out.println("Please enter the z coordinate of the storage space");
        z = textInput.nextInt();

        location = x + " " + y + " " + z;

        fileData = new FileReaderWriter();
        String s = barcode + " " + location;
        System.out.println("Data {" + s + "} will now be added to file");
        try {
            fileData.addToInventory("Warehouse", s);
        } catch (IOException e) {
            System.out.println("Failed to write data to file.");
        }

    }

    public void take(String s){

        System.out.println("Item " + barcode + " is at [" + location + "]");
    }

    public boolean find(String l, String s){
        fileData = new FileReaderWriter();
        try {
            success = fileData.findInInventory(l, s);
        } catch (IOException e) {
            System.out.println("Failed to use finder method");
        }
        return success;
    }

    public void locate(String l, String s){
        fileData = new FileReaderWriter();
        try {
            fileData.locateInInventory(l, s);
        } catch (IOException e) {
            System.out.println("Failed to use locator method");
        }
    }
}
