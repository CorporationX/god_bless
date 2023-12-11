package faang.school.godbless.BJS2_511;

import faang.school.godbless.BJS2_511.creatures.*;

public class Main {
    public static void main(String[] args) {
        Creature pikeman = new Pikeman(40);
        Creature angel = new Angel(200);
        Creature griffin = new Griffin(38);
        Creature swordman = new Swordman(42);

        Hero hero1 = new Hero("Hero1", "fraction1");
        Hero hero2 = new Hero("Hero2", "fraction2");

        hero1.addCreature(griffin, 1);
        hero1.addCreature(angel, 1);
        hero1.addCreature(swordman, 1);
        hero2.addCreature(pikeman, 1);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winner = battlefield.battle();

        System.out.println("Winner: " + winner.getName() + " from " + winner.getFraction());

    }
}