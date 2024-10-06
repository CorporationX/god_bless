package school.faang.heroes;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class BattleField {
    private Hero hero1;
    private Hero hero2;

    public Hero battle() {
        int powerHero1 = countArmyPower(hero1.getArmy());
        int powerHero2 = countArmyPower(hero2.getArmy());
        if (powerHero1 > powerHero2) {
            return hero1;
        } else if (powerHero1 < powerHero2) {
            return hero2;
        } else {
            return null;
        }
    }

    private int countArmyPower(Map<Creature, Integer> army) {
        int power = 0;
        for (var entry : army.entrySet()) {
            Creature creature = entry.getKey();
            Integer quantity = entry.getValue();
            power += quantity * creature.damage();
        }
        return power;
    }
}
