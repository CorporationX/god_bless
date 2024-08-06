package faang.school.godbless;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Angel extends Creature {

    public Angel() {
        super("Angel", 7, 20, 20, 5, 200);
    }

    @Override
    public int getDamage() {
        return getAttack();
    }
}
