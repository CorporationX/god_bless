package lordOfTheRings_811;

import lombok.Data;

@Data
public class Item {
    private String name;
    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }
}