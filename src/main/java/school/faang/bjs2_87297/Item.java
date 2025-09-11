package school.faang.bjs2_87297;

import lombok.Getter;

public class Item {
    @Getter
    private String name;
    @Getter
    private Integer value;

    public Item(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}
