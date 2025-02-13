package BJS257348;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> itemCallback) {
        if (character != null && item != null) {
            ArrayList<Item> characterItems = character.getInventory();
            characterItems.add(item);
            character.setInventory(characterItems);

            itemCallback.accept(item);
        }
    }

    public void updateItem(Character character, Predicate<Item> condition,
                           Function<Item, Item> updateFunction) {
        if (character != null) {
            ArrayList<Item> characterItems = character.getInventory();
            for (int i = 0; i < characterItems.size(); i++) {
                Item currentItem = characterItems.get(i);
                // Проверяем на нужный нам предмет
                if (condition.test(currentItem)) {
                    // Обновляем
                    characterItems.set(i, updateFunction.apply(currentItem));
                }
            }
        } else {
            System.out.println("Error: character is null");
        }
    }


    public void removeItem(Character character, Item item, Predicate<Item> nameFilterCallback) {

        if (character != null && item != null) {
            if (nameFilterCallback.test(item)) {
                ArrayList<Item> characterItems = character.getInventory();
                characterItems.remove(item);
                character.setInventory(characterItems);
            }

        }

    }
}
