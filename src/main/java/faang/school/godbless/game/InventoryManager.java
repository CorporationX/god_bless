package faang.school.godbless.game;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> itemHandler) {
        List<Item> itemList = character.getInventory();
        if (itemList != null) {
            itemList.add( item );
            itemHandler.accept( item );
        } else {
            System.out.println( "Error: List is null" );
        }
    }

    public void removeItem(Character character, Predicate<Item> predicate) {
        List<Item> itemList = character.getInventory();
        if (checkListIsNullOrEmpty( itemList )) {
            System.out.println( "Error: List is null or empty" );
            return;
        }

        itemList.removeIf( predicate::test );

    }

    public void updateItem(Character character, Predicate<Item> isRightItem, Function<Item, Item> updateFunction) {
        List<Item> itemList = character.getInventory();
        if (checkListIsNullOrEmpty( itemList )) {
            System.out.println( "Error: List is null or empty" );
            return;
        }
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get( i );
            if (isRightItem.test( itemList.get( i ) )) {
                character.getInventory().set( i, updateFunction.apply( item ) );
            }
        }
    }

    private boolean checkListIsNullOrEmpty(List<Item> list) {
        return list == null || list.isEmpty();
    }
}
