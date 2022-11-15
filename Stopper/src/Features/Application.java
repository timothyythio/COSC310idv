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

    Material material1 = new Material("glass", 600, 900, 400);
    Material material2 = new Material("wood", 600, 800, 100);
    Material material3 = new Material("bricks", 120, 535, 553);
    Material material4 = new Material("polyester", 343, 500, 160);
    Material material5 = new Material("vinyl", 655, 700, 157);
    Material material6 = new Material("clay", 655, 900, 234 );
    Material material7 = new Material("aluminum", 712, 850, 654);
    Material material8 = new Material("iron", 600, 700, 745);
    Material material9 = new Material("steel", 1145, 1200, 756);
    Material material10 = new Material("plastic", 1563, 1600, 836);

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

        if(materialIndex <= 0 && materialIndex > 9){
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
        materialList.addMaterial(material6);
        materialList.addMaterial(material7);
        materialList.addMaterial(material8);
        materialList.addMaterial(material9);
        materialList.addMaterial(material10);
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
                case 5:
                    material6.exportAmount(amount);
                    System.out.println("Currently there are " + material6.getAmount() + " of " + material6.getName());
                    break;
                case 6:
                    material7.exportAmount(amount);
                    System.out.println("Currently there are " + material7.getAmount() + " of " + material7.getName());
                    break;
                case 7:
                    material8.exportAmount(amount);
                    System.out.println("Currently there are " + material8.getAmount() + " of " + material8.getName());
                    break;
                case 8:
                    material9.exportAmount(amount);
                    System.out.println("Currently there are " + material9.getAmount() + " of " + material9.getName());
                    break;
                case 9:
                    material10.exportAmount(amount);
                    System.out.println("Currently there are " + material10.getAmount() + " of " + material10.getName());
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
                case 5:
                    material6.importAmount(amount);
                    System.out.println("Currently there are " + material6.getAmount() + " of " + material6.getName());
                    break;
                case 6:
                    material7.importAmount(amount);
                    System.out.println("Currently there are " + material7.getAmount() + " of " + material7.getName());
                    break;
                case 7:
                    material8.importAmount(amount);
                    System.out.println("Currently there are " + material8.getAmount() + " of " + material8.getName());
                    break;
                case 8:
                    material9.importAmount(amount);
                    System.out.println("Currently there are " + material9.getAmount() + " of " + material9.getName());
                    break;
                case 9:
                    material10.importAmount(amount);
                    System.out.println("Currently there are " + material10.getAmount() + " of " + material10.getName());
                    break;
                default:
                    System.out.println("End of the import application!!!");
            }
        }
    }
}
