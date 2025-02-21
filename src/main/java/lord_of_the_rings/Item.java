package lord_of_the_rings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {
    private final String name;
    private int value;

    @Override
    public String toString() {
        return String.format("Item: name - '%s', value - '%d'", name, value);
    }
}