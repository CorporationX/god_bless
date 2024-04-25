package faang.school.godbless.armyOfHeroesOfMightAndMagic;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SquadCalculate extends Thread {
    private Creature creature;
    private int squadPower;

    public SquadCalculate(Creature creature) {
        this.creature = creature;
    }

    @Override
    public void run() {
        squadPower = creature.getSquadPower();
    }
}
