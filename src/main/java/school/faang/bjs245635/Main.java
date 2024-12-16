package school.faang.bjs245635;

public class Main {
    public static void main(String[] args) {

        Character bubba = new Character("Bubba");
        Item ball = new Item("Ball", 50);
        Item bone = new Item("Bone", 10);

        InventoryManager inventoryManager = new InventoryManager();

        inventoryManager.addItem(bubba, ball, (item) ->
                System.out.printf("%s was added to inventory\n", item.getName()));

        inventoryManager.addItem(bubba, bone, (item) ->
                System.out.printf("%s was added to inventory\n", item.getName()));

        inventoryManager.removeItem(bubba, item -> item.getName().equals("Ball"));

        inventoryManager.updateItem(bubba, item -> item.getName().equals("Bone"),
                item -> new Item(item.getName(), item.getValue() * 5));
        inventoryManager.updateItem(bubba, item -> item.getName().equals("Ball"),
                item -> new Item(item.getName(), item.getValue() * 5));

        bubba.getInventory().forEach(item -> {
            System.out.println(item.getName() + ": " + item.getValue());
        });
    }
}