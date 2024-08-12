package faang.school.godbless.bjs2_21238;

public class Main {
    public static void main(String[] args) {
        var character = new Character();
        var item = new Item("Item", 1);

        var manager = new InventoryManager();

        manager.addItem(character, item, i -> System.out.println(i.getName() + " was added to inventory"));
        manager.updateItem(character, i -> i.getName().startsWith("I"), i -> new Item(i.getName(), i.getValue() + 1));
        manager.removeItem(character, i -> i.getName().startsWith("I"));
        System.out.println();
    }
}
