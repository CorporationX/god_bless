package school.faang.bsj2_90800;

public class Main {
    private static final int SWORD_VALUE = 1000;
    private static final int RING_VALUE = 1000000;
    private static final int VALUE_FOR_COMPARE = 1000000;

    public static void main(String[] args) {

        Item sword = new Item("Sword", SWORD_VALUE);
        Item ring = new Item("Ring", RING_VALUE);
        Character character = new Character("Hero");

        InventoryManager inventoryManager = new InventoryManager();
        inventoryManager.addItem(character,
                sword,
                ((addeditem) ->
                        System.out.printf("%s добавлено герою %s\n",
                                addeditem.name(),
                                character.getName())));

        inventoryManager.addItem(character,
                ring,
                (item) -> System.out.printf("%s добавлено герою %s\n",
                        item.name(),
                        character.getName()));

        System.out.println("\nAfter adding items\n");
        for (Item characterItem : character.inventory) {
            System.out.printf("%s has %s with value %d\n",
                    character.getName(),
                    characterItem.name(),
                    characterItem.value());
        }

        inventoryManager.updateItem(character,
                (searchedItem) -> searchedItem.name().equals("Ring"),
                (updatedItem) -> new Item(updatedItem.name(),
                        updatedItem.value() * 2));

        System.out.println("\nAfter updating item\n");
        for (Item characterItem : character.inventory) {
            System.out.printf("%s has %s with value %d\n",
                    character.getName(),
                    characterItem.name(),
                    characterItem.value());
        }

        inventoryManager.removeItem(character, (item) -> item.value() < VALUE_FOR_COMPARE);
        System.out.println("\nAfter removing items\n");
        for (Item characterItem : character.inventory) {
            System.out.printf("%s has %s with value %d\n",
                    character.getName(),
                    characterItem.name(),
                    characterItem.value());
        }
    }
}

