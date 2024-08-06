package faang.school.godbless.Task18288;

import faang.school.godbless.Task18288.Army.Angel;
import faang.school.godbless.Task18288.Army.Griffin;
import faang.school.godbless.Task18288.Army.PikeMan;
import faang.school.godbless.Task18288.Army.SwordMan;
import faang.school.godbless.Task18288.Battle.BattleField;

public class Main {
    public static void main(String[] args) {

        Hero redHero = new Hero("Red Hero", "Castle", 2, 1);
        Hero blueHero = new Hero("Blue Hero", "Rampart", 3, 2);

        PikeMan pikeMan = new PikeMan();
        Griffin griffin = new Griffin();
        redHero.addCreature(pikeMan, 100);
        redHero.addCreature(griffin, 1);

        SwordMan swordMan = new SwordMan();
        Angel angel = new Angel();
        blueHero.addCreature(swordMan, 75);
        blueHero.addCreature(angel, 20);

        BattleField battlefield = new BattleField(redHero, blueHero);
        Hero winner = battlefield.battle();

        System.out.println("The winner is: " + winner.getName());
        System.out.println(redHero.getArmy());


    }
}

