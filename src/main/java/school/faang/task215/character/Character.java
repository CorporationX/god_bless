package school.faang.task215.character;

import school.faang.task215.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private List<Item> charactersStuff = new ArrayList<>();

    public void addNewItem(Item item){
        charactersStuff.add(item);
    }
    public List<Item> getCharacterStuff(){
        return charactersStuff;
    }
    public void removeItem(Item item){
        charactersStuff.remove(item);
    }
}
