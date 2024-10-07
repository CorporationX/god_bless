package school.faangSprint2.t5;

import lombok.Getter;

@Getter
class Item {
    private String name;
    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }
}