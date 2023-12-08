package faang.school.godbless.task_1.Army;

import faang.school.godbless.task_1.Creature.Angel;
import faang.school.godbless.task_1.Creature.Creature;
import faang.school.godbless.task_1.Creature.Griffin;
import faang.school.godbless.task_1.Creature.Pikeman;
import faang.school.godbless.task_1.Creature.Swordman;

import java.util.Iterator;
import java.util.Map;

public class Battlefield {
    Hero hero1 = new Hero("Hero1", "Might", 20, 2);
    Hero hero2 = new Hero("Hero2", "Magic", 40, 4);

    public void createArmy() {
        hero1.addCreature(new Angel(), 2);
        hero1.addCreature(new Griffin(), 2);
        hero1.addCreature(new Pikeman(), 2);
        hero1.addCreature(new Swordman(), 2);

        hero2.addCreature(new Angel(), 2);
        hero2.addCreature(new Griffin(), 2);
    }

    public Hero battle() {
        createArmy();

        Map<Creature, Integer> armyHero1 = hero1.getArmy();
        Map<Creature, Integer> armyHero2 = hero2.getArmy();


        Iterator<Creature> iterator1 = armyHero1.keySet().iterator();
        Iterator<Creature> iterator2 = armyHero2.keySet().iterator();

        while (iterator1.hasNext() || iterator2.hasNext()) {
            if (!iterator1.hasNext()) {
                return hero2;
            }
            if (!iterator2.hasNext()) {
                return hero1;
            }

            Creature creature1 = iterator1.next();
            Creature creature2 = iterator2.next();



            iterator1.remove();
            iterator2.remove();

        }
        return null;
    }
}
