package faang.school.godbless;

import faang.school.godbless.creatures.Creature;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Setter
public class Battlefield {
    private static Map<Creature, Integer> armyWhite = new HashMap<>();
    private static Map<Creature, Integer> armyBlack = new HashMap<>();

    private int totalPowerArmyWhite;
    private int totalPowerArmyBlack;
    private Hero heroWhite;
    private Hero heroBlack;

    public Hero battle(Map<Hero, Map<Creature, Integer>> armies) {
        calculation();

        int i = 0;
        for (Map.Entry<Hero, Map<Creature, Integer>> entry : armies.entrySet()) {
            if (i++ == 0) {
                armyWhite = entry.getValue();
                heroWhite = entry.getKey();
            } else {
                armyBlack = entry.getValue();
                heroBlack = entry.getKey();
            }
        }

        if (totalPowerArmyWhite == totalPowerArmyBlack) {
            Random rand = new Random();
            if (rand.nextInt(2) == 0) {
                return heroWhite;
            }
            return heroBlack;
        }

        if (totalPowerArmyWhite > totalPowerArmyBlack) {
            return heroWhite;
        }
        return heroBlack;
    }

    private void calculation() {
        for (Map.Entry<Creature, Integer> entry : armyWhite.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                totalPowerArmyWhite += entry.getKey().getDamage()
                        + entry.getKey().getHealth();
            }
        }

        for (Map.Entry<Creature, Integer> entry : armyBlack.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                totalPowerArmyBlack += entry.getKey().getDamage() +
                        entry.getKey().getHealth();
            }
        }
    }
}
