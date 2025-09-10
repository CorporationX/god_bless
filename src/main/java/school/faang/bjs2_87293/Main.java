package school.faang.bjs2_87293;

public class Main {
    public static void main(String[] args) {
        Character jotaro = new Character("Jotaro");
        Item cap = new Item("Cap", 800);

        InventoryManager.addItem(cap, jotaro, (item) -> System.out.println(item.getName() + " был добавлен"));
        InventoryManager.removeItem(jotaro, (item) -> item.getName().contains("Cap"));

        InventoryManager.addItem(cap, jotaro, (item) -> System.out.println(item.getName() + " был опять добавлен"));
        InventoryManager.updateItem(jotaro,
                (item) -> item.getName().equals("Cap"), (item) -> new Item(item.getName(), item.getValue() * 2));
        jotaro.getInventory().forEach((item) -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
