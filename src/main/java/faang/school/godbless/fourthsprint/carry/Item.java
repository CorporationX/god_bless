package faang.school.godbless.fourthsprint.carry;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Item {
    private String name;
    private int power;

    @Override
    public String toString() {
        return name + " (Power: " + power + ")";
    }
}
