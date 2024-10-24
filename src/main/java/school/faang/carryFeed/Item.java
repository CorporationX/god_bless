package school.faang.carryFeed;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Item {
    private final String name;
    private final ItemType type;
    private final int power;

    public String combineName(Item item) {
        return this.name + " " + item.getName();
    }

    public ItemType combineType(Item item) {
        if (this.type.equals(item.getType())) {
            return this.type;
        } else {
            return ItemType.COMBINED;
        }
    }

    public int combinePower(Item item) {
        return this.power + item.getPower();
    }

    public Item combineWith(Item item) {
        return new Item(combineName(item), combineType(item), combinePower(item));
    }
}