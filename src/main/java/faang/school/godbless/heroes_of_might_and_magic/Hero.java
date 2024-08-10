package faang.school.godbless.heroes_of_might_and_magic;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army;

    public Hero(String name, String fraction, int experience, int level) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (fraction == null) {
            throw new IllegalArgumentException("Fraction cannot be null");
        }
        if (experience < 0) {
            throw new IllegalArgumentException("Experience cannot be negative");
        }
        if (level < 0) {
            throw new IllegalArgumentException("Level cannot be negative");
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (fraction.isEmpty()) {
            throw new IllegalArgumentException("Fraction cannot be empty");
        }
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
        this.army = new HashMap<>();
    }

    public void addCreature(Creature creature, int quantity) {
        army.put(creature, quantity);
        creature.setQuantity(quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        if (army.containsKey(creature)) {
            int currentQuantity = army.get(creature);
            int newQuantity = Math.max(currentQuantity - quantity, 0);
            if (newQuantity == 0) {
                army.remove(creature);
            } else {
                army.put(creature, newQuantity);
                creature.setQuantity(newQuantity);
            }
        }
    }
}
