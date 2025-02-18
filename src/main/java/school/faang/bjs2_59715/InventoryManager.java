package school.faang.bjs2_59715;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@NoArgsConstructor
public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> action) {
        checkCharacter(character);
        checkItem(item);
        checkAction(action);

        action.accept(item);
        character.getInventory().add(item);
    }

    public void removeItem(Character character, Predicate<Item> filter) {
        checkCharacter(character);
        checkFilter(filter);

        List<Item> items = new ArrayList<>(character.getInventory());
        for (Item item : items) {
            if (filter.test(item)) {
                character.getInventory().remove(item);
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> filter, Function<Item, Item> transformation) {
        checkCharacter(character);
        checkFilter(filter);
        checkTransformation(transformation);

        List<Item> items = character.getInventory();
        for (Item item : items) {
            if (filter.test(item)) {
                int indexItem = items.indexOf(item);
                items.set(indexItem, transformation.apply(item));
            }
        }
    }

    private void checkCharacter(Character character) {
        Objects.requireNonNull(character, "Персонаж не должен быть null");
    }

    private void checkItem(Item item) {
        Objects.requireNonNull(item, "Предмет не должен быть null");
    }

    private void checkAction(Consumer<Item> action) {
        Objects.requireNonNull(action, "Обработчик не должен быть null");
    }

    private void checkFilter(Predicate<Item> filter) {
        Objects.requireNonNull(filter, "Фильтр не должен быть null");
    }

    private void checkTransformation(Function<Item, Item> transformation) {
        Objects.requireNonNull(transformation, "Модификатор не должен быть null");
    }

}
