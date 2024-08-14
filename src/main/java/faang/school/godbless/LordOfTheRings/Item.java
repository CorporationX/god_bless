package faang.school.godbless.LordOfTheRings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
public class Item {
    private String name;
    private int value;

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", value=" + value + '}';
    }
}
