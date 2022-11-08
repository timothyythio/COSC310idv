package fileRW;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReaderWriter {

    int a;
    int i;
    boolean success;
    String location;
    List<String> lines;
    PrintWriter writer;

    public void listInventory(String storage) throws IOException {
        if (storage.equals("Office")) {
            lines = Files.readAllLines(Paths.get("office.txt"));
            i = 1;
        }
        if (storage.equals("Warehouse")) {
            lines = Files.readAllLines(Paths.get("warehouse.txt"));
            i = 3;
        }
        for (String line : lines){
            ArrayList<String> partsOfLine = splitOnSpace(line);
            System.out.print("Barcode: "+partsOfLine.get(0) + " ");
            System.out.print("Spot: ");
            for (a = 1; a <= i; a++) {
                if (a > 1) {
                    System.out.print(", ");
                }
                System.out.print(partsOfLine.get(a));
            }
                System.out.println();
            }
        }
    public void storeIntoInventory(String storage, String spot) throws IOException {
        if (storage.equals("Office")) {
            lines = Files.readAllLines(Paths.get("office.txt"));
            writer = new PrintWriter("office.txt","UTF-8");
        }
        if (storage.equals("Warehouse")) {
            lines = Files.readAllLines(Paths.get("warehouse.txt"));
            writer = new PrintWriter("warehouse.txt","UTF-8");
        }
        lines.add(spot);
        for (String line : lines){
            writer.println(line);
        }
        writer.close();
    }

    public boolean findInInventory(String storage, String barcode) throws IOException {
        if (storage.equals("Office")) {
            lines = Files.readAllLines(Paths.get("office.txt"));
        }
        if (storage.equals("Warehouse")) {
            lines = Files.readAllLines(Paths.get("warehouse.txt"));
        }
        for (String line : lines){
            ArrayList<String> partsOfLine = splitOnSpace(line);
            if (barcode.equals(partsOfLine.get(0))) {
                success = true;
            }
        }
        return success;
    }

    public void locateInInventory(String storage, String barcode) throws IOException {
        if (storage.equals("Office")) {
            lines = Files.readAllLines(Paths.get("office.txt"));
            i = 1;
        }
        if (storage.equals("Warehouse")) {
            lines = Files.readAllLines(Paths.get("warehouse.txt"));
            i = 3;
        }
        for (String line : lines){
            ArrayList<String> partsOfLine = splitOnSpace(line);
            if (barcode.equals(partsOfLine.get(0))) {
                location = partsOfLine.get(1);
                for (a = 2; a <= i; a++) {
                    location += ", " + partsOfLine.get(a);
                }
                System.out.println("Item " + barcode + " is in the " + storage + " spot [" + location + "].");
            }
        }
    }

    public void takeFromInventory(String storage, String barcode) throws IOException {
        if (storage.equals("Office")) {
            lines = Files.readAllLines(Paths.get("office.txt"));
            writer = new PrintWriter("office.txt","UTF-8");
            i = 1;
        }
        if (storage.equals("Warehouse")) {
            lines = Files.readAllLines(Paths.get("warehouse.txt"));
            writer = new PrintWriter("warehouse.txt","UTF-8");
            i = 3;
        }
        for (String line : lines){
            ArrayList<String> partsOfLine = splitOnSpace(line);
            if (barcode.equals(partsOfLine.get(0))) {
                location = partsOfLine.get(1);
                for (a = 2; a <= i; a++) {
                    location += ", " + partsOfLine.get(a);
                }
                System.out.println("Item " + barcode + " is in the " + storage + " spot [" + location + "] ready for pick up.");
            }
            else {
                writer.println(line);
            }
        }
        writer.close();
    }

    public static ArrayList<String> splitOnSpace(String line){
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }
}
