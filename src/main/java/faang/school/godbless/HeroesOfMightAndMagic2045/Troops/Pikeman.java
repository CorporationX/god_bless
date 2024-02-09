package faang.school.godbless.HeroesOfMightAndMagic2045.Troops;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class Pikeman extends Creature {

    private static final String NAME = "Pikeman";

    public Pikeman(int lvl) {
        super(lvl);
        this.setName(NAME);
        this.setAttack(3);
        this.setDefence(1);
        this.setSpeed(1);
    }
}
