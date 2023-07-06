package faang.school.godbless.sprint3_lambda.rpg;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer) {
        character.getInventory().add(item);
        consumer.accept(item);
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
//       character.getInventory().removeIf(predicate); // убери, if item подходит условию; predicate- принимает знач. и return true or false
//        List<Item> inventory = character.getInventory();  // создаем copy inventory = кд
        List<Item> items = character.getInventory();
        items.stream().filter(predicate).findFirst().ifPresent(items::remove);  //stream -> открываем поток из объектов item,
                                                                                // фильтруем объекты по условию, находим первый попавш объект,
                                                                                // если он == null or isEmpty, то удаляем
                                                                                // items::remove == items -> item -> items.remove(items)
//        for (Item item: character.getInventory()){     // Проходимся по каждому предмету ->
//            if (item.equals(predicate)){               // сравниваем его с условием ->
//                character.getInventory().remove(item); // если подходит, то удаляем ->
//                break;                                 // выйти из цикла
//            }
//        }
    }

    public void updateItem(Character character, Predicate<Item> predicate, Function<Item, Item> function) {
        for (Item item : character.getInventory()) {
            if (predicate.test(item)) {
                function.apply(item);
                character.getInventory().set(character.getInventory().indexOf(item), item);
            }
        }
    }
}
