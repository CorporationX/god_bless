package school.faang.bjs2_57397;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " inventory was added"));
        manager.removeItem(frodo, (item -> item.getName().equals("The One Ring")));
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " added again"));
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"),
                (item) -> item.setValue(item.getValue() * 2));

        StringBuilder sb = new StringBuilder();
        frodo.getItems().forEach(item -> sb.append(item.getName())
                .append(": ")
                .append(item.getValue())
                .append(System.lineSeparator()));
        System.out.println(sb);
    }
}
