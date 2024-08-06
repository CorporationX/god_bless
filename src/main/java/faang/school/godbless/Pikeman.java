package faang.school.godbless;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Pikeman extends Creature {

    public Pikeman() {
        super("Pikeman", 1, 4, 5, 20, 10);
    }

    @Override
    public int getDamage() {
        return getAttack();
    }
}
