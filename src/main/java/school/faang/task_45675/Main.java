package school.faang.task_45675;

public class Main {

    public static void main(String[] args) {
        Character gerald = new Character("Gerald");
        Item sword = new Item("The One Sword", 100);

        InventoryManager manager = new InventoryManager();
        manager.addItem(gerald, sword, item -> System.out.println(item.name()
                + " Добавлен в инвентарь, цена " + item.value()));

        manager.updateItem(gerald, item
                -> item.name().equals("The One Sword"), item
                -> new Item(item.name(), item.value() * 3));

        gerald.getInventory().forEach(item -> System.out.println(item.name() + " " + item.value()));

        manager.removeItem(gerald, item -> item.name().equals("The One Sword"));
    }
}
