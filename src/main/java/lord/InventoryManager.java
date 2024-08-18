package lord;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Data
public class InventoryManager {

    public static void addItem(Character character, Item item, Consumer consumer) {
        if (character.equals(item)) {
            throw new IllegalArgumentException();
        } else {
            List<Item> newList = new ArrayList<>(character.getItemList());
            newList.add(item);
            character.setItemList(newList);
            consumer.accept(item);
        }
    }

    public static void removeItem(Character character, Predicate<Item> predicate) {
        for (int i = 0; i < character.getItemList().size(); i++) {
            if (predicate.test(character.getItemList().get(i))) {
                character.getItemList().remove(character.getItemList().get(i));
            }
        }

    }

    public static void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        for (int i = 0; i < character.getItemList().size(); i++) {
            Item item = character.getItemList().get(i);
            if (predicate.test(character.getItemList().get(i))) {
               character.getItemList().set(i, function.apply(item));
            }
        }
    }

    public static void outputList(List<Item> itemList) {
        for (int i = 0; i < itemList.size(); i++) {
            System.out.println(itemList.get(i));
        }
    }
}
