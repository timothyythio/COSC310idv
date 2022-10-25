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
    boolean success = false;
    List<String> lines;
    PrintWriter writer;
    public void addToInventory(String storage, String spot) throws IOException {
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

        lines.add(spot);
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
            writer.println(line);
        }
        lines.remove(spot); //DEBUG only, keep source files unchanged
        writer.close();
    }

    public void takeFromInventory(String s) throws IOException {

    }

    public boolean findInInventory(String storage, String spot) throws IOException {

        return success;
    }

    public void locateInInventory(String storage, String spot) throws IOException {

    }

    public static ArrayList<String> splitOnSpace(String line){
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }
}
