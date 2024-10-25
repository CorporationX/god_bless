package school.faang.Multithreading.sprint_4.CurryEat;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Item {
    private String name;
    private int power;

    public Item combineNewItem(Item item){
        return new Item(name + item.name, power + item.power);
    }
}
