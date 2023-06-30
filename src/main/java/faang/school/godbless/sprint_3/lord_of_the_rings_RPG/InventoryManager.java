package faang.school.godbless.sprint_3.lord_of_the_rings_RPG;


import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemConsumer) {
        character.getInventory().add(item);
        itemConsumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> itemPredicate) {
        List<Item> inventory = character.getInventory();
        for (Item item : inventory) {
            if (itemPredicate.test(item)) {
                inventory.remove(item);
            }
        }
    }

    public void updateItem(Character character, Predicate<Item> itemPredicate, Function<Item, Item> itemFunction) {
        List<Item> inventory = character.getInventory();
        for (Item item : inventory) {
            if (itemPredicate.test(item)) {
                Item newItem = itemFunction.apply(item);
                inventory.set(inventory.indexOf(item), newItem);
            }
        }
    }
}
/*Создайте класс Item с полями name и value;

Создайте класс Character с полем inventory, которое является списком объектов типа Item;

Создайте класс InventoryManager с методами:


addItem:
принимает объект типа Character и объект типа Item,
добавляет предмет в инвентарь персонажа и принимает Consumer,
который будет выполняться после успешного добавления предмета;

removeItem:
принимает объект типа Character и объект типа Predicate<Item>,
удаляет предмет из инвентаря персонажа, если предмет удовлетворяет условию, заданному предикатом;

updateItem:
принимает объект типа Character, объект типа Predicate<Item> и объект типа Function<Item, Item>,
находит предмет в инвентаре персонажа, который удовлетворяет условию, заданному предикатом, и обновляет его, применяя функцию.
 */
