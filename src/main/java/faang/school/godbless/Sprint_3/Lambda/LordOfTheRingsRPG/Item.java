package faang.school.godbless.Sprint_3.Lambda.LordOfTheRingsRPG;

import lombok.Getter;

@Getter
public class Item {
    private String name;
    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
