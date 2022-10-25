package cosc310proj;
import java.util.Scanner; 


public class main {
	public static void main(String[] args) {

			start();
		
		}
	
	public static void start() {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please select an option: ");
		System.out.println("(1) Add new product");
		System.out.println("(2) View product");
		System.out.println("(3) Edit product");
		int selection = 0; 
		boolean pass = false;
		while (!pass) {
			try {
				selection = in.nextInt();
				if (selection > 3 || selection < 1) 
					System.out.println("Enter number between 1 and 3");
				else pass = true; 
				
			} catch (Exception e) {
				in.nextLine();
				System.out.println("Please enter a number.");
			}
			
		
		}
		
		switch (selection) {
		
		case 1: ProductWriter.writeProduct(); break;
		case 2: DataReader.readData(); break;
		case 3: DataReader.changeData(); break;
		
		}

	}	
	
	public static void finish() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to make another selection? (y/n)");
		String yn = sc.nextLine();	
		if (yn.equals("y"))	
			start();
		else if (yn.equals("n"))
			System.out.println("Thank you!");
		sc.close();
	}

}