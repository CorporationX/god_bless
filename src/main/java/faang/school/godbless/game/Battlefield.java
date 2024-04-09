package faang.school.godbless.game;

import java.util.Map;

public class Battlefield {
    private Hero firstHero;
    private Hero secondHero;

    public Battlefield(Hero firstHero, Hero secondHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
    }

    private int sumCommonPower(Hero hero) {
        int commonPower = 0;
        for(Map.Entry<Creature, Integer> entry : hero.getArmy().entrySet()){
            commonPower += entry.getValue();
        }
        return commonPower;
    }

    public Hero battle() {
        int commonPowerOfFirstHero = sumCommonPower(firstHero);
        int commonPowerOfSecondHero = sumCommonPower(secondHero);

        if (commonPowerOfFirstHero > commonPowerOfSecondHero) {
            return firstHero;
        } else if (commonPowerOfFirstHero < commonPowerOfSecondHero) {
            return secondHero;
        } else {
            return null;
        }
    }
}
