package cosc310proj;
import java.util.Scanner; 


public class mainStock {
	public static void main(String[] args)  {

			start();
		
		}
	
	public static void start()  {
		try {
			
			Scanner in = new Scanner(System.in);
			System.out.println("-----------Menu-----------");
			System.out.println("Please select an option: ");
			System.out.println("(1) Add new product");
			Thread.sleep(100);
			System.out.println("(2) View product");
			Thread.sleep(100);
			System.out.println("(3) Edit product");
			Thread.sleep(100);
			System.out.println("(4) Exit Program");
			int selection = 0; 
			boolean pass = false;
			while (!pass) {
				try {
					selection = in.nextInt();
					if (selection > 4 || selection < 1) 
						System.out.println("Enter number between 1 and 3");
					else pass = true; 
					
				} catch (Exception e) {
					in.nextLine();
					System.out.println("Please enter a number.");
				}
				
			
			}
			
			switch (selection) {
			
			case 1: ProductWriter.addProduct(); break;
			case 2: DataReader.readProduct(); break;
			case 3: DataReader.changeProduct(); break;
			case 4: closeProgram(); break;
			
			}
			
		} catch(InterruptedException e)  {
			
			System.out.println(e);
			
		}
		

	}	
	
	public static void finish()  {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to make another selection? (y/n)");
		boolean pass = false;
		while (!pass) {
			String yn = sc.nextLine();	
			if (yn.equals("y"))	{
				pass = true;
				start();
			}
			else if (yn.equals("n")) {
				System.out.println("Thank you!");
				pass = true;
			} else System.out.println("Input a valid option");
		}
			sc.close();
	}
	
	public static int closeProgram() {
		System.out.println("Goodbye!");
		return 0;
		
	}

}
