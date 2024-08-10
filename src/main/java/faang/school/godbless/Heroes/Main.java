package faang.school.godbless.Heroes;

import faang.school.godbless.Heroes.UI.Angel;
import faang.school.godbless.Heroes.UI.Battlefield;
import faang.school.godbless.Heroes.UI.Creature;
import faang.school.godbless.Heroes.UI.Griffin;
import faang.school.godbless.Heroes.UI.Hero;
import faang.school.godbless.Heroes.UI.Pikeman;
import faang.school.godbless.Heroes.UI.Swordman;

public class Main {
    public static void main(String[] args) {
        Creature griffin1 = new Griffin(1, 1);
        Creature pikeman1 = new Pikeman(1, 1);
        Creature angel1 = new Angel(1, 1);
        Creature swordman1 = new Swordman(1, 1);
        Hero player1 = new Hero("1", "1", 1, 1);
        player1.addCreature(griffin1, 2);
        player1.addCreature(pikeman1, 2);
        player1.addCreature(angel1, 2);
        player1.addCreature(swordman1, 2);


        Creature griffin2 = new Griffin(1, 1);
        Creature pikeman2 = new Pikeman(1, 1);
        Creature angel2 = new Angel(1, 1);
        Creature swordman2 = new Swordman(1, 1);
        Hero player2 = new Hero("2", "1", 1, 1);
        player2.addCreature(griffin2, 3);
        player2.addCreature(pikeman2, 3);
        player2.addCreature(angel2, 3);
        player2.addCreature(swordman2, 3);
        Battlefield battlefield = new Battlefield(player1, player2);
        battlefield.battle();
    }
}
