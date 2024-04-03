package faang.school.godbless;

import faang.school.godbless.Creature;
import faang.school.godbless.Hero;
import faang.school.godbless.Battlefield;

import java.util.HashMap;

public class Main20 {

    public static void main(String[] args) {
        Creature.Pikeman pikeman1 = new Creature.Pikeman();
        Creature.Griffin griffin1 = new Creature.Griffin();
        Creature.Swordman swordman1 = new Creature.Swordman();
        Creature.Angel angel1 = new Creature.Angel();

        Hero hero1 = new Hero("Hero1", "Fraction1", 0, 1, new HashMap<>());
        Hero hero2 = new Hero("Hero2", "Fraction2", 0, 1, new HashMap<>());

        hero1.addCreature(pikeman1, 20);
        hero1.addCreature(griffin1, 3);
        hero1.addCreature(swordman1, 10);
        hero1.addCreature(angel1, 1);

        hero2.addCreature(pikeman1, 40);
        hero2.addCreature(griffin1, 5);
        hero2.addCreature(swordman1, 20);

        System.out.println("Initial armies:");
        printArmyInfo(hero1);
        printArmyInfo(hero2);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winner = battlefield.battle();

        if (winner != null) {
            System.out.println("\nWinner: " + winner.getName());
            System.out.println("Winner's Army: " + winner.getArmy());
        } else {
            System.out.println("\nThe battle ended in a draw!");
        }
    }

    private static void printArmyInfo(Hero hero) {
        System.out.println(hero.getName() + "'s Army:");
        for (Creature creature : hero.getArmy()) {
            System.out.println(creature.getName());
        }
        System.out.println();
    }
}