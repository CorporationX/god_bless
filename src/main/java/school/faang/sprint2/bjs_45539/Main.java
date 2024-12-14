package school.faang.sprint2.bjs_45539;

public class Main {
    public static void main(String[] args) {
        Character frodo = new Character();
        Item ring = new Item("ring", 1000);
        Item mirror = new Item("mirror", 300);
        Item hat = new Item("hat", 700);

        InventoryManager manager = new InventoryManager();
        String strItemAdded = " был добавлен в инвентарь.";
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + strItemAdded));
        manager.addItem(frodo, mirror, (item) -> System.out.println(item.getName() + strItemAdded));
        manager.addItem(frodo, hat, (item) -> System.out.println(item.getName() + strItemAdded));

        manager.removeItem(frodo, (item) -> item.getName().contains("ir"));
        manager.addItem(frodo, mirror, (item) -> System.out.println(item.getName() + " снова" +strItemAdded));
        System.out.println("----------");
        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getItemCost()));

        manager.updateItem(frodo, (item) -> item.getName().equals("mirror"),
                (item) -> new Item(item.getName(), item.getItemCost() * 2));
        manager.updateItem(frodo, (item) -> item.getName().startsWith("ri"),
                (item) -> new Item(item.getName().concat(" of King"), item.getItemCost() + 1250));
        System.out.println("----------");
        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getItemCost()));
    }
}
