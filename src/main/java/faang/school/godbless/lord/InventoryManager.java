package faang.school.godbless.lord;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InventoryManager {

    public void addItem(Hero hero, Item item, Consumer<Item> consumer) {
        if (hero == null) {
            throw new IllegalArgumentException("Hero not be null in method addItem");
        }
        if (item == null) {
            throw new IllegalArgumentException("Item not be null in method addItem");
        }
        hero.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Hero hero, Predicate<Item> examinationAboutRemove) {
        if (hero == null) {
            throw new IllegalArgumentException("Hero not be null in method removeItem");
        }
        hero.getInventory().removeAll(hero.getInventory()
                .stream()
                .filter(examinationAboutRemove)
                .collect(Collectors.toSet())
        );
    }

    public void updateItem(Hero hero, Predicate<Item> examinationAboutUpdate,
                           Function<Item, Item> functionUpdate) {
        if (hero == null) {
            throw new IllegalArgumentException("Hero not be null in method updateItem");
        }
        hero.getInventory().addAll(hero.getInventory().stream()
                .filter(examinationAboutUpdate)
                .map(functionUpdate::apply)
                .collect(Collectors.toSet())
        );
    }
}
