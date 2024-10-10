package school.faang.lord_of_the_tings;

import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Character character = new Character();
        InventoryManager managerMyHero = new InventoryManager(character);
        Item swordItem = new Item("sword", 100);
        Item hetchetItem = new Item("hatchet", 50);
        managerMyHero.addItem(swordItem);
        managerMyHero.addItem(hetchetItem);

        managerMyHero.updateItem(conditionSword, 200);
        managerMyHero.removeItem(conditionHatchet);
        character.getInventory().stream().forEach(item -> System.out.println(item.getName()));
    }

    private static final Predicate<Item> conditionSword = item -> item.getName().equals("sword");
    private static final Predicate<Item> conditionHatchet = item -> item.getName().equals("hatchet");
}
