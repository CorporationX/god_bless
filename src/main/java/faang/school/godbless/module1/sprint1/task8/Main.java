package faang.school.godbless.module1.sprint1.task8;

import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Alex","Alliance", 0L, 5, new LinkedHashMap<>());
        Hero hero2 = new Hero("Trall","Horde", 0L, 6, new LinkedHashMap<>());

        hero1.addCreature(new Griffin(),100);
        hero1.addCreature(new Swordman(),100);
        hero1.addCreature(new Pikeman(),100);
        hero1.addCreature(new Angel(),100);

        hero2.addCreature(new Griffin(), 120);
        hero2.addCreature(new Swordman(), 120);
        hero2.addCreature(new Pikeman(), 120);
        hero2.addCreature(new Angel(), 120);

        Battlefield.battle(hero1,hero2);
    }
}
