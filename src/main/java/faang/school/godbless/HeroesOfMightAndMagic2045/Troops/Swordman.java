package faang.school.godbless.HeroesOfMightAndMagic2045.Troops;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class Swordman extends Creature {

    private static final String NAME = "Swordman";

    public Swordman(int lvl) {
        super(lvl);
        this.setName(NAME);
        this.setAttack(2);
        this.setDefence(2);
        this.setSpeed(2);
    }
}
