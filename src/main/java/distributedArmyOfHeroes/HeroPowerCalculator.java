package distributedArmyOfHeroes;

import lombok.Getter;

@Getter
public class HeroPowerCalculator extends Thread {
    private final Hero hero;
    private int totalPower;

    public HeroPowerCalculator(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void run() {
        totalPower = hero.getPower();
    }
}
