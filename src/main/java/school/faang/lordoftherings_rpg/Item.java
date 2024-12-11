package school.faang.lordoftherings_rpg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private String name;
    private int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
