package Features;

import javax.naming.LimitExceededException;

public class Material {
    private String name;
    private int amount; 
    private int maxStock;
    private int minStock;
    
    public Material (String name, int amount, int maxStock, int minStock) {
        setName(name);
        setAmount(amount);
        setMaxStock(maxStock);
        setMinStock(minStock);
    }
    
    //SETTERS
    public void setName(String name) {
        this.name = name;
    }
    public void setAmount(int amount) {
        if(amount > 0) {
            this.amount = amount;
        }
    }
    public void setMaxStock(int maxStock) {
        if(maxStock > 0) {
            this.maxStock = maxStock;
        }
    }
    public void setMinStock(int minStock) {
        if(minStock >= 0) {
            this.minStock = minStock;
        }
    }
    
    //GETTERS
    public String getName() {
        return name;
    }
    public int getAmount() {
        return amount;
    }
    public int getMaxStock() {
        return maxStock;
    }
    public int getMinStock() {
        return minStock;
    }

    //EFFECTS: increases the amount by the imported amount if it does not exceed the maxStock.
    public void importAmount(int imported) throws LimitExceededException {
        if ((this.amount + imported) <= this.getMaxStock()) {
            this.amount += imported;
        } else {
            throw new LimitExceededException("You reached the maximum capacity");
        }
    }

    //EFFECTS: decreases the amount by the exported amount if it has enough stock.
    public void exportAmount(int exported) throws LimitExceededException {
        if (this.amount >= exported) {
            this.amount -= exported;
            checkMinAmount();
        } else {
            throw new LimitExceededException("Not enough stock left to export");
        }
    }

    //EFFECTS: checks if the amount left is below minStock
    public void checkMinAmount() {
        if(this.amount <= this.getMinStock()) {
            giveWarning();
        }
    }

    //EFFECTS: It gives the warning the user if the stock is below minStock
    public void giveWarning() {
        System.out.println("Your stock is low!!!");
    }

    @Override
    public String toString() {
        return "Material: "  + name.toUpperCase() +
                ", amount left: " + amount + "\n";
    }
}
