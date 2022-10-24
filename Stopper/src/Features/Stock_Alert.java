package Features;

import java.util.ArrayList;

public class Stock_Alert {

    //InventoryMaterials inventoryMaterials = new InventoryMaterials();

    int currentStockMaterial1 = 100;
    int currentStockMaterial2 = 50;
    int currentStockMaterial3 = 200;
    int currentStockMaterial4 = 150;

    int maxStockMaterial1 = 200;
    int maxStockMaterial2 = 150;
    int maxStockMaterial3 = 250;
    int maxStockMaterial4 = 300;

    int minStockMaterial1 = 50;
    int minStockMaterial2 = 20;
    int minStockMaterial3 = 10;
    int minStockMaterial4 = 60;

    ArrayList<Integer> currentStocks = new ArrayList();
    ArrayList<Integer> maxStocks = new ArrayList<>();
    ArrayList<Integer> minStocks = new ArrayList<>();

    //EFFECTS: Adds the average stock of the materials to ArrayList
    private void addingCurrentArrayList() {
        currentStocks.add(currentStockMaterial1);
        currentStocks.add(currentStockMaterial2);
        currentStocks.add(currentStockMaterial3);
        currentStocks.add(currentStockMaterial4);
    }

    //EFFECTS: Adds the maximum stock of the materials to ArrayList
    private void addingMaxArrayList() {
        maxStocks.add(maxStockMaterial1);
        maxStocks.add(maxStockMaterial2);
        maxStocks.add(maxStockMaterial3);
        maxStocks.add(maxStockMaterial4);
    }

    //EFFECTS: Adds the minimum stock of the materials to ArrayList
    private void addingMinArrayList() {
        minStocks.add(minStockMaterial1);
        minStocks.add(minStockMaterial2);
        minStocks.add(minStockMaterial3);
        minStocks.add(minStockMaterial4);
    }

    //EFFECTS: Checks the stock level of the material
    //REQUIRES: ArrayLists of the materials and their max and min stock level values
    public void checkStockLevel(String materialName, int materialIndex){
        addingCurrentArrayList();
        addingMaxArrayList();
        addingMinArrayList();
        int materialStock = currentStocks.get(materialIndex);
        //materialName = inventoryMaterials.materialList.get(materialIndex);

        if(materialStock < minStocks.get(materialIndex)){
            lowQuantity(materialName);
        }
        else if(materialStock >= maxStocks.get(materialIndex)){
            maxQuantity(materialName);
        }
        else{
            normalQuantity(materialName);
        }
    }

    //EFFECTS: prints the alert message when there is lower quantity than desired
    private void lowQuantity(String materialName){
        System.out.println("Alert!!!\nLow quantity for " + materialName);
    }

    //EFFECTS: prints the alert message when there is higher quantity than desired
    private void maxQuantity(String materialName){
        System.out.println("Alert!!!\nMaximum quantity achieved for " + materialName);
    }

    //EFFECTS: prints the message when there is enough quantity
    private void normalQuantity(String materialName){
        System.out.println("Enough quantity of " + materialName);
    }

}
