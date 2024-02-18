package faang.school.godbless.game;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class InventoryManager {
    public void addItem(Character character, Item item, Consumer<Item> consumer){
        List<Item> itemList = character.getInventory();
        if(itemList!=null){
            itemList.add(item);
            consumer.accept( item );
        }else{
            System.out.println("Error: List is null");
        }
    }

    public void removeItem(Character character, Predicate<Item> predicate){
        List<Item> itemList = character.getInventory();

        if(itemList==null || itemList.isEmpty()){
            System.out.println("Error: List is null or empty");
          } else{
            itemList.removeIf( predicate::test);
        }
    }

    public void updateItem(Character character, Predicate<Item> isRightItem, Function<Item, Item>  function){
        List<Item> itemList = character.getInventory();
        if(itemList==null || itemList.isEmpty()){
            System.out.println("Error: List is null or empty");
            return;
        }
        for(Item item: itemList){
            if(isRightItem.test( item )){
                function.apply( item );
            }
        }

    }
}
