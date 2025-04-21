package school.faang.lotr_rpg;


import lombok.Getter;

@Getter
public class Item {
    private String name;
    private int value;

    Item(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
