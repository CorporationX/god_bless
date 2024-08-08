package faang.school.godbless.BJS2_18872;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Creature {
    protected String name;
    protected int level;
    protected int damage;
    protected int protection;
    protected int speed;
    protected int quantity;

}
