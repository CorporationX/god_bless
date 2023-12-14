package LordOfTheRingsRPG;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private String item;
    private int value;

    public Item(String item, int value) {
        this.item = item;
        this.value = value;
    }
}
