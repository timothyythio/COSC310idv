package Features;

import java.util.ArrayList;
import java.util.ArrayList.*;
import Features.Material;

public class MaterialList{

    private ArrayList<Material> materials;

    public MaterialList() {
        materials = new ArrayList<>();
    }

    public boolean addMaterial(Material material) {
        return materials.add(material);
    }

    public ArrayList<Material> getMaterialList() {
        return materials;
    }

    @Override
    public String toString() {
        String temp = "Materials: \n";
        for(Material m: materials){
            temp += m.toString();
        }
        return temp;
    }

    //REQUIRES: index >= 0
    public Material getMaterialByIndex(int index) {
        return materials.get(index);
    }

    public void setMaterialByIndex(Material material, int index) {
        materials.set(index, material);
    }

}
