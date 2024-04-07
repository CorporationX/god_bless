package faang.school.godbless.game;

import faang.school.godbless.game.characters.Angel;
import faang.school.godbless.game.characters.Griffin;
import faang.school.godbless.game.characters.Pikeman;
import faang.school.godbless.game.characters.Swordman;

public class Main {

    public static void main(String[] args) {

        Hero hero1 = new Hero("Bob", "ONE", "EASY", 1);
        Hero hero2 = new Hero("Lola", "TWO", "Medium", 3);

        Creature pikeman = new Pikeman(90);
        Creature swordman = new Swordman(70);
        Creature angel = new Angel(50);
        Creature griffin = new Griffin(180);

        hero1.addCreature(pikeman, 90);
        hero1.addCreature(swordman, 70);
        hero1.addCreature(griffin, 80);

        hero2.addCreature(angel, 50);
        hero2.addCreature(griffin, 80);
        hero2.addCreature(pikeman, 90);

        hero2.removeCreature(pikeman);

        System.out.println("List army1: " + hero1.getArmy());
        System.out.println("List army2: " + hero2.getArmy());

        Battlefield battlefield = new Battlefield(hero1, hero2);

        Hero winnerHero = battlefield.battle();
        System.out.println(winnerHero != null ? "Winner: " + winnerHero : "It's DRAW!");
    }
}
