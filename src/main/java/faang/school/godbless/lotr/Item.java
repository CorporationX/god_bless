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

    public void setValue(int value) {
        validateValue(value);

        this.value = value;
    }

    public void setName(String name) {
        validateName(name);

        this.name = name;
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Arguments can't be empty.");
        }

        if (name == null) {
            throw new IllegalArgumentException("Arguments can't be null");
        }
    }

    private void validateValue(int value){
        if(value < 0){
            throw new IllegalArgumentException("Value can't be less then zero");
        }
    }
}

