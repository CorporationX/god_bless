package distributedArmyOfHeroesOfMightAndMagic_35930;

import distributedArmyOfHeroesOfMightAndMagic_35930.entity.Unit;
import lombok.Getter;

public class CalculatorPower extends Thread {
    private final Unit creature;
    @Getter
    private int power;

    public CalculatorPower(Unit creature) {
        this.creature = creature;
    }

    @Override
    public void run() {
        System.out.println("Выполняется поток -" + Thread.currentThread().getName());
        power = creature.getPower();
        System.out.println("Выполнился поток -" + Thread.currentThread().getName());
    }
}
