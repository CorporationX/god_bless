package faang.school.godbless.lotr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CharacterTest {

    @Test
    void testConstructor_ShouldThrowException_IfNameIsEmpty() {
        String message = "Name can't be empty.";

        assertThrows(IllegalArgumentException.class, () -> new Character(" "), message);
    }


    @Test
    void testRemoveItemIf_ShouldRemoveItemFromTheInventoryListAccordingToPassedConditions() {
        Character character = new Character("Grigory");
        Item donut = new Item("Donut",1);
        character.addItem(donut);
        character.removeItemIf((item) -> item.getName().equals("Donut"));

        int expectedOutput = 0;
        int actualOutput = character.getInventory().size();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void testUpdateItemIf_ShouldUpdateItemInInventoryAccordingToPassedConditionsAndUpdaterLogic() {
        Character character = new Character("Grigory");
        Item donut = new Item("Donut", 1);
        character.addItem(donut);
        character.updateItemIf((item) -> item.getName().equals("Donut"), (item) -> new Item(item.getName(), item.getValue() * 1000));

        int actualOutput = character.getInventory().get(0).getValue();
        int expectedOutput = 1000;

        assertEquals(expectedOutput, actualOutput);
    }
}
