package school.faang.stream2.lordoftheringsrpg;

import lombok.Data;

@Data
public class Item {
    private String name;
    public int value;

    public Item(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
