package school.faang;

public class Main {
    public static void main(String[] args) {
        // Задача Хогвартс
        SpellCaster spellCaster = new SpellCaster();

        String accio = "Accio";
        String lumos = "Lumos";
        String aparecium = "Aparecium";

        spellCaster.cast(accio, (spell) -> "The object is attracted by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(aparecium, (spell) -> "The secret message is revealed by " + spell);
        // Задача Властелин Колец
        InventoryManager manager = new InventoryManager();

        Character frodo = new Character("Frodo");
        Item ring = new Item("The one Ring", 1000);

        manager.addItem(frodo, ring, (item) ->
                System.out.printf("Предмет: %s был добавлен в инвентарь\n", item.getName()));
        manager.removeItem(frodo, (item) -> item.getName().equals("The one Ring"));

        manager.addItem(frodo, ring, (item) ->
                System.out.printf("Предмет: %s cнова был добавлен в инвентарь\n", item.getName()));
        manager.updateItem(frodo, (item) -> item.getName().equals("The one Ring"),
                (item) -> new Item(item.getName(), item.getValue() * 2));

        System.out.println(frodo.getInventory().get(0).getValue());

    }
}
