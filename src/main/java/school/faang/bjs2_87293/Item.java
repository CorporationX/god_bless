package school.faang.bjs2_87293;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Item {
    private String name;
    private int value;

    public Item(String name, int value) {
        if ((name == null || name.isBlank()) || (value <= 0)) {
            throw new IllegalArgumentException("У предмета должно быть название и цена > 0");
        }
        this.name = name;
        this.value = value;
    }
}
