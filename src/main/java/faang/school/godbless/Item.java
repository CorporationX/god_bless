package faang.school.godbless;

import lombok.Getter;

@Getter
public class Item {
    String name;
    int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }

}
