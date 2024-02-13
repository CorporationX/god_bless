package faang.school.godbless.LOTRRPG2588;

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