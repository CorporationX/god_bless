package faang.school.godbless.Task_Lord_of_the_Rings;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.function.Consumer;

@NoArgsConstructor
public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.addItemToInventory(item);
        consumer.accept(item);
    }

}
