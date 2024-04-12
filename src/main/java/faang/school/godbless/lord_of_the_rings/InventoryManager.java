package faang.school.godbless.lord_of_the_rings;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemConsumer){
        character.getInventory().add(item);
        itemConsumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate, Consumer<Item> itemConsumer){
        Optional<Item> itemToRemove = character.getInventory().stream().filter(itemPredicate).findFirst();
        if (itemToRemove.isPresent()){
            character.getInventory().remove(itemToRemove.get());
            itemConsumer.accept(itemToRemove.get());
        }
        else {
            System.out.println("Нет такого предмета для удаления в инвентаре");
        }
    }
    public void updateItem(Character character, Predicate<Item> itemPredicate,
                           Function<Item, Item> itemFunction, Consumer<Item> itemConsumer){
        Optional<Item> itemToUpdate = character.getInventory().stream().filter(itemPredicate).findFirst();
        if (itemToUpdate.isPresent()){
            Item updateItem = itemFunction.apply(itemToUpdate.get());
            itemConsumer.accept(updateItem);
        }
        else {
            System.out.println("Нет такого предмета для обновления в инвентаре");
        }
    }
}
