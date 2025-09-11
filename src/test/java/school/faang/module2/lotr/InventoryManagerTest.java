package school.faang.module2.lotr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class InventoryManagerTest {

    private final Character frodo = new Character("Frodo", new ArrayList<>());
    private final Item ring = new Item("The One Ring", 1000);
    private final Item robe = new Item("Elves robe", 10);
    private final InventoryManager manager = new InventoryManager();

    @Test
    void testInventory() {
        manager.createCharacter(frodo);
        manager.addItem(frodo, ring, (item) -> System.out.printf("%s был добавлен в инвентарь.%n", item.name()));
        manager.addItem(frodo, robe, (item) -> System.out.printf("%s был добавлен в инвентарь.%n", item.name()));
        Assertions.assertEquals(frodo.inventory(), List.of(ring, robe));

        manager.removeItem(frodo, (item) -> item.name().contains("Ring"));
        Assertions.assertEquals(frodo.inventory(), List.of(robe));

        manager.addItem(frodo, ring, (item) -> System.out.printf("%s снова добавлен.%n", item.name()));
        Assertions.assertEquals(frodo.inventory(), List.of(robe, ring));

        manager.updateItem(frodo,
                (item) -> Objects.equals(item.name(), "The One Ring"),
                (item) -> new Item(item.name(), item.value() * 2)
        );
        Assertions.assertEquals(frodo.inventory(), List.of(robe, new Item(ring.name(), ring.value() * 2)));
    }

}