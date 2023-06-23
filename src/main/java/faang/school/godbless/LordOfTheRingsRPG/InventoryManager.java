package faang.school.godbless.LordOfTheRingsRPG;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer consumer) {
        character.addItemToInventory(item); // добавляем в инветарь предмет
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicateRemove) { // predicate - boolean
        character.getInventory().removeIf(predicateRemove); // удаляем предмет если он есть в инвентаре
    }

    public void updateItem(Character character, Predicate<Item> predicateUpdate, Function<Item, Item> itemFunction) {
        character.getInventory().stream()
                .filter(predicateUpdate) // filter - отработает по заданному условию
                .findFirst()// findFirst - первое знач. которое подходит по условию
                .ifPresent(f -> character.getInventory().set(character.getInventory().indexOf(f), itemFunction.apply(f)));
                // ifPresent - если есть здесь что-то => выполнить условие
    }

}
