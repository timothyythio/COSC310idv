package Main;

import Features.InventoryMaterials;
import Features.Stock_Alert;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner stockReader = new Scanner(System.in);
        Stock_Alert alert = new Stock_Alert();
        InventoryMaterials inventoryMaterials = new InventoryMaterials();

        String materialName;

        System.out.println("Stock level checking");
        System.out.println("Write the name of the material you want to check stock of: ");
        materialName = stockReader.nextLine();

        if(inventoryMaterials.correctMaterialInput(materialName)){
            inventoryMaterials.choosingMaterial(materialName);
        }
        else{
            System.out.println("There in none of that material");
        }


    }
}
