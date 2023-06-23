package faang.school.godbless.lotr;

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
        validateName(name);
        validateValue(value);

        this.name = name;
        this.value = value;
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name can't be empty.");
        }
    }

    private void validateValue(int value){
        if(value < 0){
            throw new IllegalArgumentException("Value can't be less then zero");
        }
    }
}

