package school.faang.m1s4.bsj2_38762_dota;

public class Main {
    public static void main(String[] args) {
        Item shuriken = new Item("Shuriken", 4);
        Item cannon = new Item("Cannon", 5);
        Item chain = new Item("Chain", 8);
        Item saw = new Item("Saw", 7);

        Inventory inventory = new Inventory();

        System.out.println(inventory);

        inventory.combineItems(shuriken, cannon);
        inventory.combineItems(chain, saw);


        System.out.println(inventory);
    }
}
