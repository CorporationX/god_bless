package faang.school.godbless.lord_of_the_rings.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Character {
    private String name;
    private List<Item> inventory = new ArrayList<>();

    public Character(String name) {
        this.name = name;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Predicate<Item> predicate) {
        emptyCheck();
        Iterator<Item> itemIterator = inventory.iterator();
        while (itemIterator.hasNext()) {
            Item item = itemIterator.next();
            if (predicate.test(item)) {
                itemIterator.remove();
            }
        }
    }

    public void updateItem(Predicate<Item> predicate, Function<Item, Item> function) {
        emptyCheck();
        ListIterator<Item> itemIterator = inventory.listIterator();
        while (itemIterator.hasNext()) {
            Item item = itemIterator.next();
            if (predicate.test(item)) {
                itemIterator.set(function.apply(item));
            }
        }
    }

    private void emptyCheck() {
        if (inventory == null || inventory.isEmpty()) {
            throw new IllegalArgumentException("inventory is empty");
        }
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", inventory=" + inventory.toString() +
                '}';
    }

}
