package inventory;
import java.util.Scanner; 

public class inven1 {
	public String iname;
	public boolean checked = true;
	int price;
	public boolean checked()
	{
		return checked;
	}
	
	public void take() {
		
		checked = false;
	}
	
	public void returned() {
		checked = true;
		System.out.println("Item is returned ");
	}
	
	public int getPrice() 
	{
		if (price >0) {
			return price;
		}else {
			System.out.println("Price is not available");
			return 0;
		}
	}
	
}


