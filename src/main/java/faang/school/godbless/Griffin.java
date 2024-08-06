package faang.school.godbless;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Griffin extends Creature {

    public Griffin() {
        super("Griffin", 3, 8, 8, 15, 25);
    }

    @Override
    public int getDamage() {
        return getAttack();
    }
}
