package faang.school.godbless.lord_of_the_rings;

import faang.school.godbless.instagram.model.FilterProcessor;
import faang.school.godbless.instagram.model.Image;
import faang.school.godbless.lord_of_the_rings.model.Character;
import faang.school.godbless.lord_of_the_rings.model.InventoryManager;
import faang.school.godbless.lord_of_the_rings.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryManagerTest {
    Character frodo;
    Item ring;
    Item sword;
    InventoryManager inventoryManager;

    @BeforeEach
    public void setUp() {
        frodo = new Character("Frodo");
        ring = new Item("The One Ring", 1000);
        sword = new Item("Anduril", 500);
        inventoryManager = new InventoryManager();
    }

    @Test
    public void addItem_shouldReturnNewListItem() {
    }

}
