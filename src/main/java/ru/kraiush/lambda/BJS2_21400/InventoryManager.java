package ru.kraiush.lambda.BJS2_21400;

import lombok.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InventoryManager {

    Character character;
    Item item;

    public static InventoryManager addItemToCharacter(Character character, Item item) {

        if (character == null || item == null) {
            return null;
        }
        InventoryManager valueUpdate = new InventoryManager(character, item);
        character.getInventory().add(item);
        return valueUpdate;
    }

    public static List<InventoryManager> deleteItemFromCharecter(Character character, Item item, List<InventoryManager> listManagers) {

        if (character == null || item == null || listManagers == null || listManagers.isEmpty()) {
            return null;
        }

        Predicate<InventoryManager> invPredicate1 = (p) -> p.getCharacter() != character;
        Predicate<InventoryManager> invPredicate2 = (p) -> p.getItem() != item;

        listManagers = listManagers.stream()
//                .filter(valueUpdate -> valueUpdate.getCharacter() !=character && valueUpdate.getItem() != item)
                .filter(invPredicate1.and(invPredicate2))
                .collect(Collectors.toList());
        character.getInventory().remove(item);
        return listManagers;
    }

    public static void changeItem(Character character, Item item, Item itemSwap, List<InventoryManager> listManagers) {
        try {

            Optional<InventoryManager> itemToChange =
                    listManagers.stream()
//                        .peek(p -> System.out.println("element: " + p))
                            .filter(o -> o.getCharacter().equals(character) && o.getItem().equals(item)).findAny();

            itemToChange.ifPresent(value -> {
                value.setItem(itemSwap);
                character.getInventory().set(character.getInventory().indexOf(item), itemSwap);
            });
        } catch (NullPointerException ex) {
            System.out.println("Unpredictaable enter!");
        }
    }

    public static void updateItem(String itemName, List<Item> listItems) {

            Function<Item, Integer> func = (p) -> p.getName().equals(itemName) ? p.getValue() * 2 : 1;

            List<Integer> valueUpdate = listItems.stream()
                    .filter(o -> o.getName().equals(itemName))
                    .map(func)
                    // .map(o -> o.getName().equals(itemName) ? o.getValue() * 2) : 1)
                    .toList();
            List<Item> itemUpdate = listItems.stream()
                    .filter(x -> x.getName().equals(itemName))
                    .toList();

            itemUpdate.get(0).setValue(valueUpdate.get(0));
        }
}