package Features;

import Features.Material;
import Features.MaterialList;
import org.w3c.dom.ls.LSOutput;

import javax.naming.LimitExceededException;
import java.util.Locale;
import java.util.Scanner;

public class Application {

    Scanner readApp = new Scanner(System.in);
    MaterialList materialList = new MaterialList();

    Material material1 = new Material("wood", 100, 200, 20);
    Material material2 = new Material("steel", 50, 100, 10);
    Material material3 = new Material("plastics", 200, 400, 50);
    Material material4 = new Material("textile", 300, 550, 50);
    Material material5 = new Material("brick", 150, 600, 60);

    //EFFECTS: it is the main function of the alert
    public void runApp() throws LimitExceededException {
        String appType;
        int materialIndex;
        int amount;
        materialAdd();

        System.out.println("\nPlease state the action that you wish to do?");
        System.out.print("To export material from the inventory, please type \"export\"\nOr you can type \"import\" to make an import.\n->");
        appType = readApp.nextLine().toLowerCase(Locale.ROOT);

        System.out.println("\n" + materialList.toString());
        System.out.print("Please enter the index of the material that you want to " + appType + ": \n->");
        materialIndex = readApp.nextInt() - 1;

        if(materialIndex <= 0 && materialIndex > 4){
            throw new LimitExceededException("The entered number is not on the listed materials.");
        }

        System.out.print("Please enter the amount that you wish to proceed: \n->");
        amount = readApp.nextInt();

        importExport(appType, materialIndex, amount);
    }

    //EFFECTS: adds the materials to the material list
    public void materialAdd(){
        materialList.addMaterial(material1);
        materialList.addMaterial(material2);
        materialList.addMaterial(material3);
        materialList.addMaterial(material4);
        materialList.addMaterial(material5);
    }

    //EFFECTS: it does the export and import applications based on the users choices
    private void importExport(String appType, int materialIndex, int amount) throws LimitExceededException {
        if(appType.equals("export")){
            switch (materialIndex){
                case 0:
                    material1.exportAmount(amount);
                    System.out.println("Currently there are " + material1.getAmount() + " of " + material1.getName());
                    break;
                case 1:
                    material2.exportAmount(amount);
                    System.out.println("Currently there are " + material2.getAmount() + " of " + material2.getName());
                    break;
                case 2:
                    material3.exportAmount(amount);
                    System.out.println("Currently there are " + material3.getAmount() + " of " + material3.getName());
                    break;
                case 3:
                    material4.exportAmount(amount);
                    System.out.println("Currently there are " + material4.getAmount() + " of " + material4.getName());
                    break;
                case 4:
                    material5.exportAmount(amount);
                    System.out.println("Currently there are " + material5.getAmount() + " of " + material5.getName());
                    break;
                default:
                    System.out.println("End of the export application!!!");
            }
        }
        else if(appType.equals("import")){
            switch (materialIndex){
                case 0:
                    material1.importAmount(amount);
                    System.out.println("Currently there are " + material1.getAmount() + " of " + material1.getName());
                    break;
                case 1:
                    material2.importAmount(amount);
                    System.out.println("Currently there are " + material2.getAmount() + " of " + material2.getName());
                    break;
                case 2:
                    material3.importAmount(amount);
                    System.out.println("Currently there are " + material3.getAmount() + " of " + material3.getName());
                    break;
                case 3:
                    material4.importAmount(amount);
                    System.out.println("Currently there are " + material4.getAmount() + " of " + material4.getName());
                    break;
                case 4:
                    material5.importAmount(amount);
                    System.out.println("Currently there are " + material5.getAmount() + " of " + material5.getName());
                    break;
                default:
                    System.out.println("End of the import application!!!");
            }
        }
    }
}
