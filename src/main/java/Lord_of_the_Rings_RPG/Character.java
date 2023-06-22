package Lord_of_the_Rings_RPG;

public class Character {
    private String name;
    private Item inventory;

    public Item getInventory() {
        return inventory;
    }

    public void setInventory(Item inventory) {
        this.inventory = inventory;
    }

    public Character(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
