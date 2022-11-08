package test;

import locations.Office;
import locations.Storage;
import locations.Warehouse;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class StorageMapTester {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final ByteArrayOutputStream err = new ByteArrayOutputStream();
    List<String> lines;
    PrintWriter writer;
    Scanner scanner;
    String input;
    // determines line separator appropriate for the system running the code
    String nextline = System.getProperty("line.separator");
    Storage item;

    @BeforeAll
    public static void backupData() {
        try {
            List<String> lines;
            PrintWriter writer;
            // Create backup of stored information
            lines = Files.readAllLines(Paths.get("office.txt"));
            writer = new PrintWriter("office_backup.txt","UTF-8");
            for (String line : lines){
                writer.println(line);
            }
            writer.close();
            lines = Files.readAllLines(Paths.get("warehouse.txt"));
            writer = new PrintWriter("warehouse_backup.txt","UTF-8");
            for (String line : lines){
                writer.println(line);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Testing phase: fails to inject test data");
        }
    }

    @BeforeEach
    public void injectTestData() {
        try {
            List<String> lines;
            PrintWriter writer;
            // Replace data with test data
            lines = Files.readAllLines(Paths.get("office_testdata.txt"));
            writer = new PrintWriter("office.txt","UTF-8");
            for (String line : lines){
                writer.println(line);
            }
            writer.close();
            lines = Files.readAllLines(Paths.get("warehouse_testdata.txt"));
            writer = new PrintWriter("warehouse.txt","UTF-8");
            for (String line : lines){
                writer.println(line);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Testing phase: fails to inject test data");
        }
    }

    @BeforeEach
    public void setStreams() {
        System.setOut(new PrintStream(out));
        System.setErr(new PrintStream(err));
    }

    @Test
    public void testListOffice() {
        item = new Office();
        item.list();
        String output = out.toString();
        assertEquals("Barcode: 123 Spot: desk" + nextline
                + "Barcode: 456 Spot: table" + nextline
                + "Barcode: 789 Spot: fridge" + nextline, output);
    }

    @Test
    public void testListWarehouse() {
        item = new Warehouse();
        item.list();
        String output = out.toString();
        assertEquals("Barcode: 111 Spot: 1, 2, 3" + nextline
                + "Barcode: 444 Spot: 4, 5, 6" + nextline
                + "Barcode: 777 Spot: 7, 8, 9" + nextline, output);
    }

    @Test
    public void testStoreOffice() {
        // Defines specific input to be used whenever prompted
        input = "bin";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        item = new Office();
        item.store("1010"); // Input is part of this method. If it's not
                                //set prior it would assume no input.
        List<String> output = null;
        try {
            output = Files.readAllLines(Paths.get("office.txt"));
        } catch (IOException e) {
            System.out.println("error in testStoreOffice");
        }
        assertEquals("[123 desk, 456 table, 789 fridge, 1010 bin]", output.toString());
    }

    @Test
    public void testStoreWarehouse() {
        // Defines specific input to be used whenever prompted
        input = "9 6 3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        item = new Warehouse();
        item.store("1010"); // Input is part of this method. If it's not
                                //set prior it would assume no input.
        List<String> output = null;
        try {
            output = Files.readAllLines(Paths.get("warehouse.txt"));
        } catch (IOException e) {
            System.out.println("error in testStoreWarehouse");
        }
        assertEquals("[111 1 2 3, 444 4 5 6, 777 7 8 9, 1010 9 6 3]", output.toString());
    }

    @Test
    public void testFindOffice() {
        item = new Office();
        assertTrue(item.find("Office", "456"));
        assertFalse(item.find("Office", "444"));
    }

    @Test
    public void testFindWarehouse() {
        item = new Warehouse();
        assertTrue(item.find("Warehouse", "777"));
        assertFalse(item.find("Warehouse", "789"));
    }

    @Test
    public void testLocateOffice() {
        item = new Office();
        item.locate("Office", "456");
        String output = out.toString();
        assertEquals("Item 456 is in the Office spot [table]." + nextline, output);
    }

    @Test
    public void testLocateWarehouse() {
        item = new Warehouse();
        item.locate("Warehouse", "444");
        String output = out.toString();
        assertEquals("Item 444 is in the Warehouse spot [4, 5, 6]." + nextline, output);
    }

    @Test
    public void testTakeOfficeTextOutput() {
        item = new Office();
        item.take("Office", "456");
        String output = out.toString();
        assertEquals("Item 456 is in the Office spot [table] ready for pick up." + nextline, output);
    }

    @Test
    public void testTakeOfficeFileInteraction() {
        item = new Office();
        item.take("Office", "456");
        List<String> output = null;
        try {
            output = Files.readAllLines(Paths.get("office.txt"));
        } catch (IOException e) {
            System.out.println("error in testTakeOfficeFileInteraction");
        }
        assertEquals("[123 desk, 789 fridge]", output.toString());
    }

    @Test
    public void testTakeWarehouseTextOutput() {
        item = new Office();
        item.take("Warehouse", "444");
        String output = out.toString();
        assertEquals("Item 444 is in the Warehouse spot [4, 5, 6] ready for pick up." + nextline, output);
    }

    @Test
    public void testTakeWarehouseFileInteraction() {
        item = new Office();
        item.take("Warehouse", "444");
        List<String> output = null;
        try {
            output = Files.readAllLines(Paths.get("warehouse.txt"));
        } catch (IOException e) {
            System.out.println("error in testTakeOfficeFileInteraction");
        }
        assertEquals("[111 1 2 3, 777 7 8 9]", output.toString());
    }

    @AfterAll
    public static void restoreInitialStreams() {
        //Restore stream to give and receive normally
        System.setIn(System.in);
        System.setOut(System.out);
        System.setErr(System.err);
        try {
            List<String> lines;
            PrintWriter writer;
            // Restore backed up data
            lines = Files.readAllLines(Paths.get("office_backup.txt"));
            writer = new PrintWriter("office.txt","UTF-8");
            for (String line : lines){
                writer.println(line);
            }
            writer.close();
            lines = Files.readAllLines(Paths.get("warehouse_backup.txt"));
            writer = new PrintWriter("warehouse.txt","UTF-8");
            for (String line : lines){
                writer.println(line);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Testing phase: failed to restore operational data");
        }
    }
}
