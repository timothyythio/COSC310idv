package cosc310proj;

import java.io.*;
import java.util.Scanner;
import java.lang.Integer;

public class DataReader {
	
	public static void readData() {
		Scanner in = new Scanner(System.in);
		System.out.println("Which product would you like to view: ");
		String prod = in.nextLine();
		
		String[] fetch = prodReturn(prod);
		
		System.out.println("Product ID: " + fetch[0]);
		System.out.println("Product Name: " + fetch[1]);
		System.out.println("Part Number: " + fetch[2]);
		System.out.println("Product Label: " + fetch[3]);
		System.out.println("Start Inventory: " + fetch[4]);
		System.out.println("Inventory Received: " + fetch[5]);
		System.out.println("Inventory Shipped: " + fetch[6]);
		System.out.println("Inventory On Hand: " + fetch[7]);
		System.out.println("Minimum Required: " + fetch[8]);
		
		main.finish();
	}
	
	public static void changeData() {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Which product would you like to change?");
		String prod = in.nextLine();
		System.out.println("What would you like to change?");
		String c = in.nextLine();
		int changeNo = 0;
		
		switch (c) {
			case "id": changeNo = 0; break;
			case "prodName": changeNo = 1; break;
			case "partNumber": changeNo = 2; break;
			case "prodLabel":changeNo = 3; break;
			case "startInventory": changeNo = 4; break;
			case "inventoryReceived": changeNo = 5; break;
			case "inventoryShipped": changeNo = 6; break;
			case "inventoryOnHand": changeNo = 7; break;
			case "minimumRequired": changeNo = 8; break;
		}
		System.out.println("New change: ");
		String change = in.nextLine();
		String[] fetch = prodReturn(prod);
		fetch[changeNo] = change;
		try {
			File file = new File("products.txt");
			FileWriter fw = new FileWriter(file.getPath(), true);
			BufferedWriter bw = new BufferedWriter(fw);	
			
			for (int i = 0; i < fetch.length; i++) {
				bw.write(fetch[i] + ", ");
			}	
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println("IO Exception!");
		}
		main.finish();
	}
	
	public static String[] prodReturn(String s) {
		String[] result = new String[9];
		try {
			File file = new File("products.txt");
			Scanner sc = new Scanner(file.getPath());
			for (int i = 1; sc.hasNext(); i++) {
				String line = sc.nextLine();
				String[] data = line.split(", ");
				if (s.equals(data[1]))
					result = data;
				
						
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			
		}
		
		return result;
		
	}
	
	public static int lineReturn(String s) {
		int result = 0;
		try {
			File file = new File("products.txt");
			Scanner sc = new Scanner(file.getPath());
			for (int i = 1; sc.hasNext(); i++) {
				String line = sc.nextLine();
				String[] data = line.split(", ");
				if (s.equals(data[1]))
					result = i;
				
						
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			
		} catch (IOException e) {
			System.out.println("IO Exception!");
		}
		
		return result; 
		
		
	}
	
}
