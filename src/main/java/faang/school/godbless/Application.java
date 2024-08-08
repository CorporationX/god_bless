package faang.school.godbless;

import faang.school.godbless.david.User;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Sir Christian", "Castle");
        Hero hero2 = new Hero("Vey", "Necropolis");

        Creature pikeman = new Pikeman(50);
        Creature griffin = new Griffin(20);
        Creature swordman = new Swordman(30);
        Creature angel = new Angel(5);

        hero1.addCreature(pikeman, 50);
        hero1.addCreature(griffin, 20);
        hero1.addCreature(swordman, 30);
        hero1.addCreature(angel, 5);

        Creature skeleton = new Pikeman(100);
        Creature vampire = new Griffin(10);

        hero2.addCreature(skeleton, 100);
        hero2.addCreature(vampire, 10);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        battlefield.battle();
    }
}
