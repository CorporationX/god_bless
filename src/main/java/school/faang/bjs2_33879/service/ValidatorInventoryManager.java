package school.faang.bjs2_33879.service;

import school.faang.bjs2_33879.model.Character;
import school.faang.bjs2_33879.model.Item;

import java.util.List;

public class ValidatorInventoryManager {

    public void validateInventoryNotNull(Character character) {
        List<Item> inventory = character.getInventory();
        if (inventory == null) {
            throw new IllegalStateException("list items cannot be null");
        }
    }
}
