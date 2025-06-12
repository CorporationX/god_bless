package school.faang.game.inventory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import school.faang.game.inventory.entity.Character;
import school.faang.game.inventory.entity.Item;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class InventoryManagerTest {
    private static InventoryManager manager;
    private static Character mainCharacter;

    @BeforeAll
    public static void setUp() {
        manager = new InventoryManager();
        mainCharacter = new Character("Ryan Thomas Gosling");
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    @Order(1)
    public void testAddAndRemoveItem(Item item, Consumer<Item> handler) {
        System.out.println("______________________");
        manager.addItem(mainCharacter, item, handler);
        assertTrue(manager.hasItem(mainCharacter, item));
        System.out.println("----------------------");
    }

    @Test
    @Order(2)
    public void testRemoveItem() {
        System.out.println("______________________");
        manager.printAllItems(mainCharacter);
        System.out.printf("\t-------\n");
        Predicate<Item> filter = item -> item.getName().contains("ppl");
        manager.removeItem(mainCharacter, filter);
        assertFalse(manager.hasItem(mainCharacter, new Item("Apple", 10)));
        manager.printAllItems(mainCharacter);
        System.out.println("----------------------");
    }

    @Test
    @Order(3)
    public void testUpdateItem() {
        System.out.println("______________________");
        Predicate<Item> filter = item -> item.getName().equalsIgnoreCase("ring");
        Function<Item, Item> processor = item -> new Item("Mega " + item.getName(), item.getValue() * 2);
        manager.updateItem(mainCharacter, filter, processor);
        Item ring = new Item("Ring", 1000);
        assertFalse(manager.hasItem(mainCharacter, ring));
        Item megaRing = new Item("Mega Ring", 2000);
        assertTrue(manager.hasItem(mainCharacter, megaRing));
        manager.printAllItems(mainCharacter);
        System.out.println("----------------------");
    }

    private static Stream<Arguments> provideParameters() {
        Consumer<Item> handler = (item) -> System.out.println(item.getName() + " successfully added to inventory.");
        return Stream.of(
                Arguments.of(new Item("Ring", 1000), handler),
                Arguments.of(new Item("Apple", 10), handler),
                Arguments.of(new Item("Sunglasses", 300), handler),
                Arguments.of(new Item("Laptop", 1500), handler)
        );
    }

}
