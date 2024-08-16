package faang.school.godbless.LordOfTheRingsRPG;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> successMessageByItem) {
        character.addItemToInventory(item);
        successMessageByItem.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> isItRemove) {
        List<Item> characterInventory = character.getInventory();
        characterInventory.removeIf(isItRemove);


    }

    public void updateItem(Character character, Predicate<Item> isItUpdate, Function<Item, Item> createUpdatedItem) {
        List<Item> characterInventory = character.getInventory();
        int lenght = characterInventory.size();
        for (int i = 0; i < lenght; i++) {
            Item temporaryItem = characterInventory.get(i);
            if (isItUpdate.test(temporaryItem))
                characterInventory.set(i, createUpdatedItem.apply(temporaryItem));
        }

    }
}
