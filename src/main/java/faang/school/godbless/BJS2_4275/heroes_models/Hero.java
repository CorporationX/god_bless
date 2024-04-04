package faang.school.godbless.BJS2_4275.heroes_models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Hero {

    private static final int MAX_FRACTION = 50;

    private String name;
    private int experience;
    private int level;
    private List<Creature> fractions;
    private boolean loss;

    public void addFraction(Creature creature) {
        if (fractions.size() <= MAX_FRACTION) {
            fractions.add(creature);
        } else {
            System.err.println("Your fraction is overcrowded");
        }
    }

    public void removeFraction(Creature creature) {
        if (!fractions.contains(creature)) {
            System.err.println(creature + " - This creature not in your fractions or fractions is empty");
        } else {
            fractions.remove(creature);
        }
    }

    public void attack(Hero enemyHero, Creature enemyFracture, int power) {
        enemyFracture.attack(power);
        if (enemyFracture.getHealth() <= 0) {
            enemyHero.getFractions().remove(enemyFracture);
        }
        if (enemyHero.getFractions().isEmpty()) {
            enemyHero.setLoss(true);
        }
    }

}
