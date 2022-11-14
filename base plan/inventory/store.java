package inventory;
import java.util.Scanner; 

public class store extends inven1 {
	inven1 v[] = new inven1 [10];
	static int i = 0;
	void addItem(String iname) {
		
		v[i] = new inven1();
		this.iname=iname;
		v[i].iname=iname;
		i++;
		System.out.println("Item added successfully");
		
	}
	void checkOut(String iname)
	{
		for (int k=0; k< i; k++)
		{
			if (v[k].iname.equalsIgnoreCase(iname)) {
				if (v[k].checked()) {
					v[k].take();
					System.out.println("Item successfully taken");
				}
				else {
					System.out.println("Item is out of stock");
				}
			}
		}
	
	}
	void returnItem(String iname) {
		if (i==0) {
			System.out.println("Item has been restocked");
		}
		for (int k =0; k<i; k++) {
			if (v[k].iname.equalsIgnoreCase(iname)) {
				v[k].checked = true;
			}
		}
	}
	public void receivePrice() {
		if (i==0) {
			System.out.println("No items in Inventory");
		}
		else {
			for (int k=0; k< i; k++) {
				System.out.println("Enter the price of the item " + v[k].iname);
				Scanner ob = new Scanner(System.in);
				v[k].price = ob.nextInt();
			}
		}
	}
	public void listInventory() {
		if (i==0) {
			System.out.println("No items in Inventory");
		}else {
			for (int k = 0; k < i;k++) {
				System.out.println(k + 1 + ". " + v[k].iname + " " + "Price: " 
						+ v[k].price + " Status: " + v[k].checked());
			}
		}
	}
}
