package faang.school.godbless.heroesofmightandmagic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army;

    public void addCreature(Creature creature, int quantity) {
        if (army == null) {
            army = new HashMap<>();
        }
        army.put(creature, quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        army.merge(creature, -quantity, Integer::sum);
        if (army.get(creature) <= 0) {
            army.remove(creature);
        }
    }

    public boolean hasArmy() {
        return army != null && !army.isEmpty();
    }

    public Map<Creature, Integer> getNextCreature() {
        Map<Creature, Integer> resultCreature = new HashMap<>();

        if (army != null && !army.isEmpty()) {
            Creature creature = army.keySet().iterator().next();

            resultCreature.put(creature, army.get(creature));

            return resultCreature;
        }

        return null;
    }

    public void fight(Hero enemy) {
        if (enemy.hasArmy() && this.hasArmy()) {
            Map<Creature, Integer> enemyNextCreature = enemy.getNextCreature();
            Creature enemyCreature = enemyNextCreature.keySet().iterator().next();
            int enemyCreatureQuantity = enemyNextCreature.get(enemyCreature);

            Map<Creature, Integer> heroNextCreature = this.getNextCreature();
            Creature heroCreature = heroNextCreature.keySet().iterator().next();
            int heroCreatureQuantity = heroNextCreature.get(heroCreature);

            int heroAttack = heroCreatureQuantity
                    * heroCreature.getQuantity()
                    * heroCreature.getDamage();
            int heroDefence = heroCreatureQuantity
                    * heroCreature.getQuantity()
                    * heroCreature.getDefence();

            int enemyAttack = enemyCreatureQuantity
                    * enemyCreature.getQuantity()
                    * enemyCreature.getDamage();
            int enemyDefence = enemyCreatureQuantity
                    * enemyCreature.getQuantity()
                    * enemyCreature.getDefence();

            if ((enemyDefence - heroAttack) == (heroDefence - enemyAttack)) {
                this.removeCreature(heroCreature, heroCreatureQuantity);
                enemy.removeCreature(enemyCreature, enemyCreatureQuantity);
            }

            if ((enemyDefence - heroAttack) < (heroDefence - enemyAttack)) {
                this.removeCreature(
                        heroCreature,
                        (heroDefence - (heroDefence - enemyAttack))
                                / (heroCreature.getQuantity()
                                * heroCreature.getDefence()));
                enemy.removeCreature(enemyCreature, enemyCreatureQuantity);
            }

            if ((heroDefence - enemyAttack) < (enemyDefence - heroAttack)) {
                enemy.removeCreature(
                        enemyCreature,
                        (enemyDefence - heroAttack)
                                / (enemyCreature.getQuantity()
                                * enemyCreature.getDefence()));
                this.removeCreature(heroCreature, heroCreatureQuantity);
            }
        }
    }
}
