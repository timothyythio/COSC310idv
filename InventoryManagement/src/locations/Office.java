package locations;

import fileRW.FileReaderWriter;

import java.io.IOException;
import java.util.Scanner;

public class Office implements Storage {

    String barcode;
    String location;
    FileReaderWriter fileData;
    Scanner textInput = new Scanner(System.in);

    //Format of spots: x-coordinate, y-coordinate, z-coordinate
    public void store(){
        System.out.println("Please enter the barcode of the item");
        barcode = textInput.nextLine();

        System.out.println("Please enter the name of the storage space");
        location = textInput.nextLine();

        fileData = new FileReaderWriter();
        String s = barcode + " " + location;
        System.out.println("Data {" + s + "} will now be added to file");
        try {
            fileData.addToInventory(s);
        } catch (IOException e) {
            System.out.println("Failed to write data to file.");
        }

    }

    public void take(){
        System.out.println("Please enter the barcode of the item");
        barcode = textInput.nextLine();
        System.out.println("Item " + barcode + " is at [" + location + "]");
    }

    public void find(){
        System.out.println("Please enter the barcode of the item");
        barcode = textInput.nextLine();
        System.out.println("Item " + barcode + " is at [" + location + "]");
    }
}
