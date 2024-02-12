package faang.school.godbless.heroes;

import faang.school.godbless.heroes.creatures.Angel;
import faang.school.godbless.heroes.creatures.Griffin;
import faang.school.godbless.heroes.creatures.Pikeman;
import faang.school.godbless.heroes.creatures.Swordman;

public class Main {
    public static void main(String... args) {
        Hero firstHero = new Hero("firstHero", "Castle", 1, 1);
        Hero secondHero = new Hero("secondHero", "Swamp", 1, 1);
        firstHero.addCreature(new Angel(), 2);
        firstHero.addCreature(new Pikeman(),20);
        secondHero.addCreature(new Griffin(), 10);
        secondHero.addCreature(new Swordman(),5);
        Battlefield battlefield = new Battlefield(firstHero, secondHero);
        System.out.println(battlefield.battle().getName() + " wins!");
    }
}
