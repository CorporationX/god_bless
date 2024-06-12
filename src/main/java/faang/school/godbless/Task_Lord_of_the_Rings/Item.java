package faang.school.godbless.Task_Lord_of_the_Rings;

import lombok.Getter;
@Getter

public class Item {
    private String name;
    private int value;

    public Item(String name, int value) {
        if (name.isBlank() || value < 0) {
            throw new IllegalArgumentException("The name can't be blank");
        } else {
            this.name = name;
            this.value = value;
        }
    }
}
