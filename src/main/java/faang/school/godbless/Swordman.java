package faang.school.godbless;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Swordman extends Creature {


    public Swordman() {
        super("Swordman", 4, 10, 12, 10, 35);
    }

    @Override
    public int getDamage() {
        return getAttack();
    }
}
