package lordoftherings;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Item {
    private String name;
    private int value;

    public Item(String name, int value) {
        Objects.requireNonNull(name, "Item name cannot be null");
        this.name = name;
        this.value = value;
    }
}
