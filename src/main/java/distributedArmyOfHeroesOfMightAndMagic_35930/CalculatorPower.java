package distributedArmyOfHeroesOfMightAndMagic_35930;

import distributedArmyOfHeroesOfMightAndMagic_35930.entity.Creature;

public class CalculatorPower extends Thread {
    private final Creature creature;
    private int power;

    public CalculatorPower(Creature creature) {
        this.creature = creature;
    }

    public int getPower() {
        return creature.getPower();
    }
}
