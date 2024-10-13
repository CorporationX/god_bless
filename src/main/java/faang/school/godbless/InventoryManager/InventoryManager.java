package faang.school.godbless.InventoryManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        consumer.accept(item);
        character.addInventory(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        for (int i = 0; i < character.getInventory().size(); i++) {
            Item i1 = character.getInventory().get(i);
            if (predicate.test(i1)) {
                character.r(i1);
            }
        }
    }
    public void updateItem(Character character, Predicate<Item> predicate, Function<Item,Item> function){
        for (int i = 0; i < character.getInventory().size(); i++) {
            if (predicate.test(character.getInventory().get(i))) {
                character.x(i,function.apply(character.getInventory().get(i)));
            }
        }
    }


    public static void main(String[] args) {
        Character frodo = new Character("Frodo");
        Item ring = new Item("The One Ring", 1000);
        Item bowAndArrow = new Item("Bow and arrow", 3000);
        Item sword = new Item("Sword", 3500);

        InventoryManager manager = new InventoryManager();

        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(frodo, bowAndArrow, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        manager.addItem(frodo, sword, (item) -> System.out.println(item.getName() + " был добавлен в инвентарь."));
        for(Item i: frodo.getInventory()){
            System.out.println(i.getName()+" tyt "+i.getValue());
        }
        manager.removeItem(frodo, (item) -> item.getName().equals("The One Ring"));
        manager.removeItem(frodo, (item) -> item.getName().equals("Bow and arrow"));
        for(Item i: frodo.getInventory()){
            System.out.println(i.getName()+" после удаления "+i.getValue());
        }
        manager.addItem(frodo, ring, (item) -> System.out.println(item.getName() + " снова добавлен."));
        manager.updateItem(frodo, (item) -> item.getName().equals("The One Ring"), (item) -> new Item(item.getName(), item.getValue() * 2));
        manager.updateItem(frodo, (item) -> item.getName().equals("Sword"), (item) -> new Item(item.getName(), item.getValue() * 2));
        for(Item i: frodo.getInventory()){
            System.out.println(i.getName()+" ?? "+i.getValue());
        }
        frodo.getInventory().forEach(item -> System.out.println(item.getName() + ": " + item.getValue()));
    }
}
