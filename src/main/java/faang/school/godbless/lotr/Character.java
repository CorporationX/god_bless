package faang.school.godbless.lotr;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Getter
public class Character {

    private String name;
    private List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        validateName(name);

        this.name = name;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItemIf(Predicate<Item> condition) {
        inventory.removeIf(condition);
    }

    public void updateItemIf(Predicate<Item> condition, Function<Item, Item> update) {
        int index = 0;
        for (Item item : inventory) {

            if (condition.test(item)) {
                Item updatedItem = update.apply(item);
                inventory.set(index,updatedItem);
            }

            index++;
        }
    }

    private void validateName(String name){
        if(name.isBlank()){
            throw new IllegalArgumentException("Name can't be empty.");
        }
    }
}
