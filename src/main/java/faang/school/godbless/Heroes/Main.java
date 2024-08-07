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
        Creature griffin = new Griffin(1, 1);
        Creature pikeman = new Pikeman(1, 1);
        Creature angel = new Angel(1, 1);
        Creature swordman = new Swordman(1, 1);
        Hero player1 = new Hero("1", "1", 1, 1);
        player1.addCreature(griffin, 2);
        player1.addCreature(pikeman, 2);
        player1.addCreature(angel, 2);
        player1.addCreature(swordman, 2);
        Hero player2 = new Hero("2", "1", 1, 1);
        player2.addCreature(new Griffin((Griffin) griffin), 1);
        player2.addCreature(new Pikeman((Pikeman) pikeman), 1);
        player2.addCreature(new Angel((Angel)angel), 1);
        player2.addCreature(new Swordman((Swordman)swordman), 1);
        Battlefield battlefield = new Battlefield(player1, player2);
        battlefield.battle();
    }
}
