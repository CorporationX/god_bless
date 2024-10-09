package school.faang.t16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Battlefield {
    private final Hero hero1;
    private final Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        List<Creature> allCreatures = new ArrayList<>();
        for (Map.Entry<Creature, Integer> entry : hero1.getArmy().entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                allCreatures.add(entry.getKey());
            }
        }

        for (Map.Entry<Creature, Integer> entry : hero2.getArmy().entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                allCreatures.add(entry.getKey());
            }
        }

        allCreatures.sort((c1, c2) -> c2.getSpeed() - c1.getSpeed());

        Map<Creature, Integer> army1 = new HashMap<>(hero1.getArmy());
        Map<Creature, Integer> army2 = new HashMap<>(hero2.getArmy());

        while (!army1.isEmpty() && !army2.isEmpty()) {
            for (Creature creature : allCreatures) {
                if (army1.containsKey(creature)) {
                    attack(creature, army2);
                } else if (army2.containsKey(creature)) {
                    attack(creature, army1);
                }

                if (army1.isEmpty() || army2.isEmpty()) {
                    break;
                }
            }
        }

        return army1.isEmpty() ? hero2 : hero1;
    }

    private void attack(Creature attacker, Map<Creature, Integer> defenderArmy) {
        if (defenderArmy.isEmpty()) {
            return;
        }

        Creature defender = defenderArmy.keySet().iterator().next();
        int damage = attacker.getDamage();
        int defenderCount = defenderArmy.get(defender);

        defenderCount -= damage / 10;

        if (defenderCount <= 0) {
            defenderArmy.remove(defender);
        } else {
            defenderArmy.put(defender, defenderCount);
        }
    }
}