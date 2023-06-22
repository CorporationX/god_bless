package sprint3task9;

import lombok.Data;

@Data
public class Item {
    private String name;
    private String value;

    public Item(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
