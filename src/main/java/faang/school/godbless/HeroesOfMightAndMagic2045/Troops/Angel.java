package faang.school.godbless.HeroesOfMightAndMagic2045.Troops;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class Angel extends Creature {

    private static final String NAME = "Angel";

    public Angel(int lvl) {
        super(lvl);
        this.setName(NAME);
        this.setAttack(1);
        this.setDefence(1);
        this.setSpeed(6);
    }
}
