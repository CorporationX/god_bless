package school.faang.sprint_4.task_50734;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Inventory inventory = new Inventory();
        Item item1 = new Item("Black", 20);
        Item item2 = new Item("King", 30);
        Item item3 = new Item("Bar", 50);

        inventory.collectItem(item1, item2);
        inventory.collectItem(item1, item3).join();
    }
}
