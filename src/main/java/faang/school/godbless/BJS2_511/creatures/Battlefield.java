package faang.school.godbless.BJS2_511.creatures;

import faang.school.godbless.BJS2_511.Hero;
import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        int power1 = powerCalculator(hero1.getArmy());
        int power2 = powerCalculator(hero2.getArmy());

        if (power1 > power2) return hero1;
        if (power1 < power2) return hero2;

        return new Random().nextBoolean() ? hero1 : hero2;
    }

    private int powerCalculator(List<Creature> armyList) {
        int totalPower = 0;

        for (Creature creature : armyList) {
            totalPower += creature.getDefence() + creature.getDefence();
        }

        return totalPower;
    }
}

class HeroesOfMightAndMagicExample {
    public static void main(String[] args) {
        Pikeman pikeman = new Pikeman(100);
        Griffin griffin = new Griffin(20);

        Hero hero1 = new Hero("Hero1", "fraction1");
        Hero hero2 = new Hero("Hero2", "fraction2");

        hero1.addCreature(pikeman, 50);
        hero1.addCreature(griffin, 10);

        hero2.addCreature(pikeman, 30);
        hero2.addCreature(griffin, 30);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winner = battlefield.battle();

        System.out.println("Winner: " + winner.getName() + " from " + winner.getFraction());
    }
}
