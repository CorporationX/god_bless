package school.faang.lotr_rpg;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        InventoryManager mgr = new InventoryManager();
        Character hobbit = new Character("Фёдор", new ArrayList<>());
        Item ring = new Item("Кольцо власти", 800);
        Item bracer = new Item("Наручи Агронома", 600);

        mgr.addItem(ring, hobbit, (item) -> System.out.println(item.getName() + ": добавлено в инвентарь"));
        mgr.addItem(bracer, hobbit, (item) -> System.out.println(item.getName() + ": добавлено в инвентарь"));

        mgr.removeItem(hobbit, (filter) -> filter.getName().contains("Наручи"));
        mgr.removeItem(hobbit, (filter) -> filter.getName().contains("Кольцо"));
        mgr.removeItem(hobbit, (filter) -> filter.getName().contains("Кольцо"));

        mgr.addItem(ring, hobbit, (item) -> System.out.println(item.getName() + ": добавлено в инвентарь"));
        mgr.addItem(bracer, hobbit, (item) -> System.out.println(item.getName() + ": добавлено в инвентарь"));

        mgr.updateItem(hobbit, item -> item.getName().equals("Кольцо власти"), item -> new Item(item.getName(), 1500));

        hobbit.getItems().forEach(item -> System.out.printf("В вашем инвентаре находится предмет %s стоимостью %d%n",
                item.getName(), item.getValue()));




    }
}
