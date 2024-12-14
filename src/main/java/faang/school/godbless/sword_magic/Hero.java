package faang.school.godbless.sword_magic;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army;

    public Hero(String name, String fraction, int experience, int level) {
        if (experience < 0) {
            throw new IllegalArgumentException("Experience cannot be negative");
        }
        if (level < 0) {
            throw new IllegalArgumentException("Level cannot be negative");
        }
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
        this.army = new HashMap<>();
    }

    public void addCreature(Creature creature, int quantity) {
        if (army.containsKey(creature)) {
            quantity += army.get(creature);
            System.out.println(creature.getName() + " was added to army of " + getName() + " in quantity: " + creature.getQuantity());
        }
        army.put(creature, quantity);
    }

    public void removeCreature(Creature creature, int quantityToRemove) {
        if (!army.containsKey(creature)) {
            System.out.println("Army does not have such creatures");
        } else {
            int quantityOfArmy = army.get(creature);
            if (quantityOfArmy > quantityToRemove) {
                army.put(creature, quantityOfArmy - quantityToRemove);
            } else {
                army.remove(creature);
            }
        }
    }

    public int getDamageOfArmy() {
        double totalDamage = 0;
        for (Map.Entry<Creature, Integer> creatureAndQuantityEntry : army.entrySet()) {
            int damageOfCreatures = creatureAndQuantityEntry.getKey().getDamage() * creatureAndQuantityEntry.getValue();
            // experience of hero impacts on creature's damage
            double finalDamageOfCreature = damageOfCreatures * (1 + 0.01 * experience);
            totalDamage += finalDamageOfCreature;
        }
        return (int) (totalDamage);
    }

    public int getArmorOfArmy() {
        double totalArmor = 0;
        for (Map.Entry<Creature, Integer> creatureAndQuantityEntry : army.entrySet()) {
            int armorOfCreatures = creatureAndQuantityEntry.getKey().getArmor() * creatureAndQuantityEntry.getValue();
            // level of hero impacts on creature's armor
            double finalArmorOfCreature = armorOfCreatures * (1 + 0.01 * level);
            totalArmor += finalArmorOfCreature;
        }
        return (int) (totalArmor);
    }

    public void showArmy() {
        for (Map.Entry<Creature, Integer> creatureEntry : army.entrySet()) {
            System.out.println(creatureEntry.getKey() + " in quality: " + creatureEntry.getValue());
        }
    }
}
