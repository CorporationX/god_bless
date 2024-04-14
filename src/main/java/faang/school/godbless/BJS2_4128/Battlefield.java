package faang.school.godbless.BJS2_4128;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Battlefield {
    private Hero attacker;
    private Hero defender;

    public Hero battle() {
        while (caclulateTotalHealth(attacker) > 0 && caclulateTotalHealth(defender) > 0) {
            applyDamage(attacker, calculateTotalDamage(defender));
            applyDamage(defender, calculateTotalDamage(attacker));
        }

        return getWinner();
    }

    private Hero getWinner() {
        if (attacker.getArmy().isEmpty()) {
            return defender;
        }

        return attacker;
    }

    private int calculateTotalDamage(Hero hero) {
        int totalDamage = 0;

        for (Creature creature : hero.getArmy()) {
            totalDamage += creature.getAttackDamage() * hero.getCreatureQuantity(creature);
        }

        return totalDamage;
    }

    private int caclulateTotalHealth(Hero hero) {
        int totalHealth = 0;

        for (Creature creature : hero.getArmy()) {
            totalHealth += (creature.getHealth() + creature.getDefense()) * hero.getCreatureQuantity(creature);
        }

        return totalHealth;
    }

    private void applyDamage(Hero hero, int totalDamage) {
        for (Creature creature : hero.getArmy()) {
            int damagePerCreature = totalDamage / hero.getArmy().size();
            int updatedHealth = creature.getHealth() - damagePerCreature;

            creature.setHealth(Math.max(updatedHealth, 0));

            if (creature.getHealth() == 0) {
                hero.setCreatureQuantity(creature, hero.getCreatureQuantity(creature) - 1);
                creature.setFullHeath();
            }
        }
    }
}
