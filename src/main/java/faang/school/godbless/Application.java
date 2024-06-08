package faang.school.godbless;

import faang.school.godbless.creatures.Angel;
import faang.school.godbless.creatures.Creature;
import faang.school.godbless.creatures.Griffin;
import faang.school.godbless.creatures.Pikeman;
import faang.school.godbless.creatures.Swordman;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<Hero, Map<Creature, Integer>> armies = new HashMap<>();

        Hero heroWhite = new Hero("White", "WhiteFraction", 1000, 6);
        Hero heroBlack = new Hero("Black", "BlackFraction", 1000, 6);

        Map<Creature, Integer> armyWhite = new HashMap<>();
        Map<Creature, Integer> armyBlack = new HashMap<>();

        armyWhite.put(new Griffin("Griffin"), 1);
        armyWhite.put(new Pikeman("Pikeman"), 7);
        armyBlack.put(new Swordman("Swordman"), 3);

        armyBlack.put(new Angel("Angel"), 2);
        armyBlack.put(new Pikeman("Pikeman"), 1);
        armyBlack.put(new Swordman("Swordman"), 6);

        armies.put(heroWhite, armyWhite);
        armies.put(heroBlack, armyBlack);

        Battlefield battlefield = new Battlefield();
        System.out.println("Win " + battlefield.battle(armies));
    }
}