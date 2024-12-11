package school.faang.task_45544;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item newItem, Consumer<Item> action) {
        characterCheck(character);
        if (newItem == null) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.EMPTYFIELD.getValue(), "item"));
        }
        if (action == null) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.EMPTYFIELD.getValue(), "action"));
        }

        character.getInventory().stream().filter(item -> item.getName().equals(newItem.getName()))
                .findFirst()
                .ifPresentOrElse(existingItem -> {
                    if (Objects.equals(existingItem.getValue(), newItem.getValue())) {
                        throw new IllegalArgumentException(
                                String.format("Предмет %s с стоимостью %s уже имеется в инвентаре",
                                        newItem.getName(),
                                        newItem.getValue()));
                    }
                }, () -> character.getInventory().add(newItem));

        action.accept(newItem);
    }

    public void removeItem(Character character, Predicate<Item> condition) {
        characterCheck(character);
        conditionCheck(condition);

        if (character.getInventory().removeIf(condition)) {
            System.out.println("Предмет был успешно удален");
        } else {
            System.out.println("Предмет не был найден в инвентаре");
        }
    }

    public void updateItem(Character character,
                           Predicate<Item> condition,
                           Function<Item, Item> updateFunction) {
        characterCheck(character);
        conditionCheck(condition);
        if (updateFunction == null) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.EMPTYFIELD.getValue(), "updateFunction"));
        }

        List<Item> updatedItems = new ArrayList<>();

        character.getInventory().stream()
                .filter(condition)
                .map(updateFunction)
                .forEach(updatedItems::add);

        updatedItems.forEach(updatedItem -> {
            var existItem = getItemByName(character.getInventory(), updatedItem.getName());
            if (existItem == null) {
                character.getInventory().add(updatedItem);
            } else {
                existItem.setValue(updatedItem.getValue());
            }
        });
    }

    private void characterCheck(Character character) {
        if (character == null) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.EMPTYFIELD.getValue(), "character"));
        }
    }

    private void conditionCheck(Predicate<Item> condition) {
        if (condition == null) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.EMPTYFIELD.getValue(), "condition"));
        }
    }

    private Item getItemByName(Set<Item> inventory, String name) {
        return inventory.stream()
                .filter(item -> item.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
