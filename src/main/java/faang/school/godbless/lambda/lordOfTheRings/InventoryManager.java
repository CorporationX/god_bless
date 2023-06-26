package faang.school.godbless.lambda.lordOfTheRings;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {

    public void addItem(Character character, Item item, Consumer<Item> consumer) throws IllegalArgumentException{
        checkNullCharacter(character);
        checkNullItem(item);
        if (consumer == null) {
            throw new IllegalArgumentException("����� ����� null!");
        }

        if (character.getInventory() == null) {
            character.setInventory(new ArrayList<>());
        }
        character.getInventory().add(item);

        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) throws IllegalArgumentException {
        checkNullCharacter(character);
        if (predicate == null) {
            throw new IllegalArgumentException("����� ����� null!");
        }

        if (character.getInventory() == null) {
            return;
        }

        character.getInventory().removeIf(predicate);
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) throws IllegalArgumentException {
        checkNullCharacter(character);
        if (predicate == null) {
            throw new IllegalArgumentException("����� ��������� ����� null!");
        }
        if (function == null) {
            throw new IllegalArgumentException("����� ������� ����� null!");
        }

        if (character.getInventory() == null)
            return;

        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                Item updatedItem = function.apply(item);
                item.setName(updatedItem.getName());
                item.setValue(updatedItem.getValue());
                break;
            }
        }
    }

    private void checkNullCharacter(Character character) throws IllegalArgumentException{
        if (character == null) {
            throw new IllegalArgumentException("������ �������� ����� null!");
        }
    }

    private void checkNullItem(Item item) throws IllegalArgumentException{
        if (item == null) {
            throw new IllegalArgumentException("������ ������� ����� null!");
        }
    }
}
