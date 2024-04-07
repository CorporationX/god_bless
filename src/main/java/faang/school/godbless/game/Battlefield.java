package faang.school.godbless.game;

public class Battlefield {
    private Hero firstHero;
    private Hero secondHero;

    public Battlefield(Hero firstHero, Hero secondHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
    }

    private int sumCommonPower(Hero hero) {
        int commonPower = 0;
        for (Creature creature : hero.getArmy()) {
            commonPower += creature.getDamage();
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
