package faang.school.godbless.heroesofmightandmagic;

import lombok.AllArgsConstructor;

import java.util.Iterator;
import java.util.Map;

@AllArgsConstructor
public class Battlefield {
    private Hero hero;
    private Hero enemy;

    public String battle() {
        while (!hero.getArmy().isEmpty() && !enemy.getArmy().isEmpty()) {
            Iterator <Map.Entry<Creature, Integer>> heroIterator = hero.getArmy().entrySet().iterator();
            while (heroIterator.hasNext()) {
                Creature heroCreature = heroIterator.next().getKey();

                Iterator <Map.Entry<Creature, Integer>> enemyIterator = enemy.getArmy().entrySet().iterator();
                while (enemyIterator.hasNext()) {
                    Creature enemyCreature = enemyIterator.next().getKey();

                    if (hero.getArmy().containsKey(heroCreature)) {
                        int heroAttack = hero.getArmy().get(heroCreature)
                                * heroCreature.getQuantity()
                                * heroCreature.getDamage();
                        int heroDefence = hero.getArmy().get(heroCreature)
                                * heroCreature.getQuantity()
                                * heroCreature.getDefence();

                        int enemyAttack = enemy.getArmy().get(enemyCreature)
                                * enemyCreature.getQuantity()
                                * enemyCreature.getDamage();
                        int enemyDefence = enemy.getArmy().get(enemyCreature)
                                * enemyCreature.getQuantity()
                                * enemyCreature.getDefence();

                        if ((enemyDefence - heroAttack) == (heroDefence - enemyAttack)) {
                            heroIterator.remove();
                            enemyIterator.remove();
                        }

                        if ((enemyDefence - heroAttack) < (heroDefence - enemyAttack)) {
                            hero.removeCreature(heroCreature, (heroDefence - (heroDefence - enemyAttack)) / (heroCreature.getQuantity() * heroCreature.getDefence()));
                            enemyIterator.remove();
                        }

                        if ((heroDefence - enemyAttack) < (enemyDefence - heroAttack)) {
                            enemy.removeCreature(enemyCreature, (enemyDefence - heroAttack) / (enemyCreature.getQuantity() * enemyCreature.getDefence()));
                            heroIterator.remove();
                        }
                    }
                }
            }
        }

        if (!hero.getArmy().isEmpty()) {
            return "Победил: " + hero.getName();
        } else if (!enemy.getArmy().isEmpty()) {
            return "Победил: " + enemy.getName();
        } else {
            return "В неравном бою слегли оба!";
        }
    }
}
