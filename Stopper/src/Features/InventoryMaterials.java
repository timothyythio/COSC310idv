package Features;

import java.util.ArrayList;
import java.util.Locale;

public class InventoryMaterials {

    Stock_Alert stockInfo = new Stock_Alert();
    
    //The names and the number of the materials that are stored in inventory may change in the future.
    //So, currently naming random materials.

    public String inventoryMaterial1 = "steel";
    public String inventoryMaterial2 = "wood";
    public String inventoryMaterial3 = "plastics";
    public String inventoryMaterial4 = "textiles";

    ArrayList<String> materialList = new ArrayList<>();

    //EFFECTS: Adds the names of the materials to ArrayList
    private void addingMaterialsSystem() {
        materialList.add(inventoryMaterial1);
        materialList.add(inventoryMaterial2);
        materialList.add(inventoryMaterial3);
        materialList.add(inventoryMaterial4);
    }

    //EFFECTS: Checks the inventory materials that the input material is stored or not.
    //REQUIRES: An input from the user
    public boolean correctMaterialInput(String inventoryMaterialSelection) {
        String materialCheck = inventoryMaterialSelection.toLowerCase();
        boolean correctMaterial;

        if (inventoryMaterialSelection == materialCheck) {
            correctMaterial = true;
        }
        else {
            correctMaterial = false;
        }
        return correctMaterial;
    }

    //EFFECTS:
    //REQUIRES:
    public void choosingMaterial(String inventoryMaterialSelection) {
        String materialChosen = inventoryMaterialSelection.toLowerCase(Locale.ROOT);
        String material = null;
        int materialIndex = 0;

        for(int i = 0; i < materialList.size(); i++){
            if(materialChosen == materialList.get(i)) {
                material = materialList.get(i);
                materialIndex = i;
            }
            else{
                material = "none";
            }
        }
        stockInfo.checkStockLevel(material, materialIndex);
    }
}
