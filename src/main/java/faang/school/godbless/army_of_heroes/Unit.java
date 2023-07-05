package faang.school.godbless.army_of_heroes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Unit {
    private String name;
    private int power;
    private int quantity;

    public int getPower() {
        return power * quantity;
    }
}
