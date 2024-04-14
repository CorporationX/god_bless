package HeroesOfMightAndMagic;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class Battlefield {
    private Hero attacker;
    private Hero defender;

    public Hero battle() {
        Hero winner = new Hero();

        Map<Creature, Integer> attackerFraction = this.attacker.getFraction();
        Map<Creature, Integer> defenderFraction = this.defender.getFraction();

        int attackerPower = 0;
        int defenderPower = 0;
        int attackerHp = 0;
        int defenderHp = 0;

        for (Map.Entry<Creature, Integer> entry : attackerFraction.entrySet()) {
            attackerPower += entry.getKey().getDamage() * entry.getValue();
            attackerHp += entry.getKey().getHp() * entry.getValue();
        }
        for (Map.Entry<Creature, Integer> entry : defenderFraction.entrySet()) {
            defenderPower += entry.getKey().getDamage() * entry.getValue();
            defenderHp += entry.getKey().getHp() * entry.getValue();
        }

        if ((attackerPower - defenderHp) > (defenderHp - attackerPower)) {
            winner = attacker;
        } else if ((attackerPower - defenderHp) < (defenderHp - attackerPower)) {
            winner = defender;
        } else {
            if (attacker.getLevel() * attacker.getExperience() >= defender.getLevel() * defender.getExperience()) {
                winner = attacker;
            } else {
                winner = defender;
            }
        }

        return winner;
    }
}
