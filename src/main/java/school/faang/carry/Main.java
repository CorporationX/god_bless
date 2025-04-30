package school.faang.carry;

public class Main {
    public static void main(String[] args) {
        ItemInventory inventory = new ItemInventory();
        inventory.getCombinedItem();

        ThreadPoolProvider.gracefullyShutdown();
        System.out.println("The end of the Program");
    }
}
