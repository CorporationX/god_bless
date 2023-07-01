package faang.school.godbless.lord_of_the_rings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManagerTests {

    private InventoryManager inventoryManager;

    private Character vitalii;
    private Character vlad;
    private Character pasha;

    private Item java;
    private Item cSharp;
    private Item python;

    private Consumer<Item> describeCSharp;
    private Consumer<Item> describeJava;
    private Consumer<Item> describePython;

    private Predicate<Item> isStrong;

    private Function<Item, Item> lifeDestroyer;

    @BeforeEach
    public void setUp() {
        inventoryManager = new InventoryManager();

        vitalii = new Character("Vitalii");
        vlad = new Character("Vlad");
        pasha = new Character("Pasha");

        java = new Item("Java", 11);
        cSharp = new Item("C#", 10);
        python = new Item("Python", 42);

        describeCSharp = (item) -> System.out.println(item + " is a good programming language!");
        describeJava = (item) -> System.out.println(item + " for the win!");
        describePython = (item) -> System.out.println(item + " is cute");

        isStrong = (item) -> item.getValue() < 11;

        lifeDestroyer = (item) -> new Item(item.getName(), 0);
    }

    @Test
    @DisplayName("Add item test")
    public void shouldAddItem() {
        inventoryManager.addItem(vitalii, cSharp, describeCSharp);
        Assertions.assertEquals(1, vitalii.getInventory().size());
    }

    @Test
    @DisplayName("Remove item test")
    public void shouldRemoveItem() {
        inventoryManager.addItem(vlad, cSharp, describeCSharp);
        inventoryManager.addItem(vlad, java, describeJava);

        inventoryManager.removeItem(vlad, isStrong);

        Assertions.assertEquals(1, vlad.getInventory().size());
    }

    @Test
    @DisplayName("Should update item")
    public void shouldUpdateItem() {
        inventoryManager.addItem(pasha, python, describePython);
        inventoryManager.addItem(pasha, java, describeJava);

        inventoryManager.updateItem(pasha, isStrong, lifeDestroyer);
    }
}
