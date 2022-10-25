package cosc310proj;
import java.util.Scanner;
import java.io.*;


public class ProductWriter {
	public static void addProduct() {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter New Product ID: ");
		String id = in.nextLine();
		System.out.println("Enter New Product Name: ");
		String pName = in.nextLine();
		System.out.println("Enter New Part Number: ");
		String pNum = in.nextLine();
		System.out.println("Enter New Product Label: ");
		String pLab = in.nextLine();
		System.out.println("Enter New Starting Inventory: ");
		String startIn = in.nextLine();
		System.out.println("Enter New Inventory Received: ");
		String inRec = in.nextLine();
		System.out.println("Enter New Inventory Shipped: ");
		String inShip = in.nextLine();
		System.out.println("Enter New Inventory On Hand: ");
		String inHand = in.nextLine();
		System.out.println("Enter New Minimum Requirement: ");
		String minReq = in.nextLine();
		writeData(id, pName, pNum, pLab, startIn, inRec, inShip, inHand, minReq);
		System.out.println("Your new product has been written successfully!");
		
		main.finish();
		
		
	}
	
	public static void writeData(String id, String pname, String pnum, String plab, String startin, String inrec, String inship, String inhand, String minreq) {
		try {
				
			File file = new File("products.txt");
			FileWriter fw = new FileWriter(file.getPath(), true);
			BufferedWriter bw = new BufferedWriter(fw);

				
			bw.write("\n" + id);
			bw.write(", " + pname);
			bw.write(", " + pnum);
			bw.write(", " + plab);
			bw.write(", " + startin);
			bw.write(", " + inrec);
			bw.write(", " + inship);
			bw.write(", " + inhand);
			bw.write(", " + minreq);	
				
			bw.close();
			} catch (IOException e) {
				System.out.println("File not found!");
			}
		
	}
}
