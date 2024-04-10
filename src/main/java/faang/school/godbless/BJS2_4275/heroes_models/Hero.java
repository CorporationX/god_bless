package faang.school.godbless.BJS2_4275.heroes_models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Hero {

    private static final int MAX_FRACTION = 50;

    private String name;
    private int experience;
    private int level;
    private List<Creature> fractions;
    private boolean loss;

    public Hero(String name, List<Creature> fractions) {
        validateData(name, fractions);
        this.name = name;
        this.experience = 0;
        this.level = 0;
        this.fractions = fractions;
        this.loss = false;
    }

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
        System.out.println("----------------------");
        System.out.println("Attacker: " + getName());
        System.out.printf("Defender: %s and his fractions size: %d%n", enemyHero.getName(), enemyHero.getFractions().size());
        System.out.println("----------------------");
        if (enemyFracture.getHealth() <= 0) {
            enemyHero.removeFraction(enemyFracture);
            setLevel(++level);
            setExperience(getExperience() + 10);
            if (getLevel() > 25 && getExperience() > 10) {
                addFraction(new Pikeman());
                setExperience(0);
            }
        }
        if (enemyHero.getFractions().isEmpty()) {
            enemyHero.setLoss(true);
        }
    }

    private void validateData(String name, List<Creature> fractions) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name hero not be empty");
        }
        if (fractions.size() < 8) {
            throw new IllegalArgumentException("Fractions error");
        }
    }
}
