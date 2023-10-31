package faang.school.godbless;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Item {
    private String name;
    private int value;

    public Item(String name, int value) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (value<0){
            throw new IllegalArgumentException("Value cannot be less 0");
        }
        this.name = name;
        this.value = value;
    }
}
