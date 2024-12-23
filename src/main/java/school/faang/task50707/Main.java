package school.faang.task50707;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addItem(new Item("blades of attack", 9, true));
        inventory.addItem(new Item("claymore", 20, true));
    }
}
