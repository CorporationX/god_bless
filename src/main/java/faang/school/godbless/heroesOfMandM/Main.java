package faang.school.godbless.heroesOfMandM;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Hero player1 = new Hero("Balck");
        Hero player2 = new Hero("Sin");
        player1.addCreature(new Pikeman("Red"), 3);
        player1.addCreature(new Griffin("Grey"), 3);
        player1.addCreature(new Pikeman("RedStrong"), 2);
        player2.addCreature(new Pikeman("Fly"), 2);
        player2.addCreature(new Swordman("Light"), 1);
        player1.addCreature(new Pikeman("RedStrong"), 2);

        for (Creature creature : player2.getArmy()) {
            System.out.println(creature);
        }
        System.out.println();

        System.out.println(new Battlefield(player1, player2).battle().getName() + " Winner!");

        for (Creature creature : player2.getArmy()) {
            System.out.println(creature);
        }
    }
}
