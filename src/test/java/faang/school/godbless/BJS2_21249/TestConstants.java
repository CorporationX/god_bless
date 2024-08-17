package faang.school.godbless.BJS2_21249;

import java.util.List;

public class TestConstants {
    public static final InventoryManager INVENTORY_MANAGER = new InventoryManager();

    public static final Item RING = new Item("The One Ring", 1000);
    public static final Item FOOD = new Item("Food", 4);
    public static final Item WATER = new Item("Water", 600);
    public static final Item CLOTHES = new Item("Clothes", 2);

    public static final Item MANTLE = new Item("Mantle", 10);
    public static final Item BREAD = new Item("Bread", 4);
    public static final Item SHIRT = new Item("Shirt", 2);

    public static final List<Item> FRODO_INVENTORY_AFTER_UPDATE = List.of(MANTLE);
    public static final List<Item> SAM_INVENTORY_AFTER_UPDATE = List.of(BREAD, WATER, SHIRT);
}
