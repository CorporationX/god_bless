package faang.school.godbless.heroes_of_might_and_magic;

import java.util.Map;

public class Battlefield {
    public void battle(Hero heroLeft, Hero heroRight) {
        if (calculateHeroScore(heroLeft) > calculateHeroScore(heroRight)) {
            System.out.println(heroLeft.getFraction() + " wins!");
        } else {
            System.out.println(heroRight.getFraction() + " wins!");
        }
    }

    public static void main(String[] args) {
        Hero heroLeft = new Hero("Elf", "Elf", 100, 10);
        Hero heroRight = new Hero("Dwarf", "Dwarf", 140, 3);

        heroLeft.addCreature(new Pikeman(), 3);
        heroLeft.addCreature(new Angel(), 10);
        heroLeft.addCreature(new Griffin(), 37);

        heroRight.addCreature(new Angel(), 10);
        heroRight.addCreature(new Pikeman(), 11);
        heroRight.addCreature(new Swordman(), 3);
        heroRight.addCreature(new Griffin(), 7);

        Battlefield battlefield = new Battlefield();
        battlefield.battle(heroLeft, heroRight);
    }

    private int calculateHeroScore(Hero hero) {
        int totalScore = 0;
        for (Map.Entry<Creature, Integer> entry : hero.getArmy().entrySet()) {
            Creature creature = entry.getKey();
            int quantity = entry.getValue();
            totalScore += creature.getDamage() * quantity;
        }
        return totalScore;
    }
}
