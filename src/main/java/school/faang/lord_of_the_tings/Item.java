package school.faang.lord_of_the_tings;

import lombok.Data;

@Data
public class Item {
    private final String name;
    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
