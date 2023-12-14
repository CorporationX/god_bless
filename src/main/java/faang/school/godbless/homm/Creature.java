package faang.school.godbless.homm;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor
public abstract class Creature {
    private String name;
    private int quantity = 0;
    private int attack;
    private int defence;
    private int speed;

    protected int getDamage() {
        return this.attack;
    }
}
