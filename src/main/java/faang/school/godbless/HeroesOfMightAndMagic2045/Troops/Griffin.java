package faang.school.godbless.HeroesOfMightAndMagic2045.Troops;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class Griffin extends Creature {

    private static final String NAME = "Griffin";

    public Griffin(int lvl) {
        super(lvl);
        this.setName(NAME);
        this.setAttack(5);
        this.setDefence(3);
        this.setSpeed(3);
    }
}
