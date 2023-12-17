package faang.school.godbless.homm.creatures;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
public abstract class Creature {
    private String name;
    private int quantity = 0;
    private int damage;
    private int defence;
    private int speed;
}
