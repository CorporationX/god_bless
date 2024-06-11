package faang.school.godbless.heroes_might_and_magic;

import faang.school.godbless.heroes_might_and_magic.entity.creature.*;
import faang.school.godbless.heroes_might_and_magic.entity.hero.Hero;

import java.util.List;
import java.util.Random;

public class Battlefield {
    private static Hero stark = new Hero("Stark", "Human", 5, 12);
    private static Hero jack = new Hero("Jack", "Elf", 6, 15);

    public static void main(String[] args) {
        stark.addCreature(new Angel(5));
        stark.addCreature(new Griffin(8));
        stark.addCreature(new Swordman(15));
        stark.addCreature(new Pikeman(10));

        jack.addCreature(new Pikeman(20));
        jack.addCreature(new Angel(15));
        jack.addCreature(new Swordman(25));

        battle(stark, jack);
    }

    public static void battle(Hero firstHero, Hero secondHero) {
        boolean flag = true;
        while (flag) {
            if (new Random().nextBoolean()) {
                attackedHero(firstHero, secondHero);
            } else {
                attackedHero(secondHero, firstHero);
            }
            if (firstHero.getArmy().isEmpty() || secondHero.getArmy().isEmpty()) {
                flag = false;
            }
        }
        if (firstHero.getArmy().isEmpty()) {
            System.out.println(secondHero.getName() + " Win!!!");
            System.out.println(secondHero);
        } else {
            System.out.println(firstHero.getName() + " Win!!!");
            System.out.println(firstHero);
        }
    }

    public static void attackedHero(Hero attackingHero, Hero defendingHero) {
        List<Creature> attacking = attackingHero.getArmy();
        List<Creature> defending = defendingHero.getArmy();
        Creature attackingCreature = attacking.get(new Random().nextInt(attacking.size()));
        Creature defendingCreature = defending.get(new Random().nextInt(defending.size()));

        int health = defendingCreature.getHealth() - attackingCreature.getDamage();
        if (health > 0) {
            defendingCreature.setHealth(health);
        } else {
            defendingHero.removeCreature(defendingCreature);
        }
    }
}
