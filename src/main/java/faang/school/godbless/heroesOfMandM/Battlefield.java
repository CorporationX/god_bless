package faang.school.godbless.heroesOfMandM;

public class Battlefield {
    Hero firstHero;
    Hero secondHero;

    public Battlefield(Hero firstHero, Hero secondHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
    }

    Hero battle() {
        while (true) {
            firstHero.attack(secondHero);
            if (secondHero.getArmy().isEmpty()) return firstHero;
            secondHero.attack(firstHero);
            if (firstHero.getArmy().isEmpty()) return secondHero;
        }
    }
}