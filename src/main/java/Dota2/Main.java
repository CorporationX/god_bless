package Dota2;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.combine();
        System.out.println(inventory.items.get(0));
    }
}
