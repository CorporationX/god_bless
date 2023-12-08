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

        if (!armyHero1.isEmpty() && !armyHero2.isEmpty()) {
            System.out.println("The battle begins!\n");
        } else {
            System.out.println("There are not enough warriors to start the battle!");
        }

        while (iterator1.hasNext() || iterator2.hasNext()) {
            if (!iterator1.hasNext()) {
                System.out.println("Battle is end!\n");
                return hero2;
            }
            if (!iterator2.hasNext()) {
                System.out.println("Battle is end!\n");
                return hero1;
            }

            Creature creature1 = iterator1.next();
            Creature creature2 = iterator2.next();

            int creaturesHealth1 = creature1.getHealth() * hero1.getArmy().get(creature1);
            int creaturesHealth2 = creature2.getHealth() * hero2.getArmy().get(creature2);

            int creatureDamages1 = creature1.getDamage(creature2) * hero2.getArmy().get(creature2);
            int creatureDamages2 = creature2.getDamage(creature1) * hero1.getArmy().get(creature1);

            while (creaturesHealth1 > 0 && creaturesHealth2 > 0) {
                if (creatureDamages1 >= creaturesHealth1) {
                    System.out.println(hero2.getName() + " -> " + creature2.getName() + " killed : " + creature1.getName() + " in " +
                                    "army " + hero1.getName());

                    creaturesHealth1 = 0;
                    iterator1.remove();
                } else {
                    System.out.println(hero1.getName() + " -> " + creature1.getName() + " damaged from: " + creature2.getName());

                    creaturesHealth1 -= creatureDamages1;
                }

                if (creatureDamages2 >= creaturesHealth2) {
                    System.out.println(hero1.getName() + " -> " + creature1.getName() + " killed :" + creature2.getName() + " in " +
                            "army " + hero2.getName());
                    creaturesHealth2 = 0;
                    iterator2.remove();
                } else {
                    System.out.println(hero2.getName() + " -> " + creature2.getName() + " damaged from: " + creature1.getName());

                    creaturesHealth2 -= creatureDamages2;
                }
            }
        }
        return null;
    }
}
