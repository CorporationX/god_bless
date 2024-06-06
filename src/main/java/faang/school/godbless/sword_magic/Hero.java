package faang.school.godbless.sword_magic;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Hero {
    private String name;
    private String fraction;
    private int experience;  // Влияет на damage армии
    private int level;       // Влияет на armor армии
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
        // Использование double не всегда точно дает результат. Один hero может иметь преимущества над другим,
        // хотя у них все характеристики равные
        BigDecimal damage = new BigDecimal(0);
        for (Map.Entry<Creature, Integer> creatureAndQuantityEntry : army.entrySet()) {
            int damageOfCreatures = creatureAndQuantityEntry.getKey().getDamage() * creatureAndQuantityEntry.getValue();
            // Влияние level на защиту армии Героя
            // finalArmor = armor * (1 + 0.01 * experience)
            BigDecimal finalDamage = increaseByPercentage(damageOfCreatures, experience);
            damage = damage.add(finalDamage);
        }
        return damage.intValue();
    }

    public int getArmorOfArmy() {
        // Использование double не всегда точно дает результат. Один hero может иметь преимущества над другим,
        // хотя у них все характеристики равные
        BigDecimal armor = new BigDecimal(0);
        for (Map.Entry<Creature, Integer> creatureAndQuantityEntry : army.entrySet()) {
            int armorOfCreatures = creatureAndQuantityEntry.getKey().getArmor() * creatureAndQuantityEntry.getValue();
            // Влияние level на защиту армии Героя
            // finalArmor = armor * (1 + 0.01 * level)
            BigDecimal finalArmorOfCreature = increaseByPercentage(armorOfCreatures, level);
            armor = armor.add(finalArmorOfCreature);
        }
        return armor.intValue();
    }

    public void showArmy() {
        for (Map.Entry<Creature, Integer> creatureEntry : army.entrySet()) {
            System.out.println(creatureEntry.getKey() + " in quality: " + creatureEntry.getValue());
        }
    }

    public BigDecimal increaseByPercentage(double initDouble, int percentage){
        return new BigDecimal("0.01")
                .multiply(new BigDecimal(percentage))
                .add(new BigDecimal(1))
                .multiply(new BigDecimal(initDouble));
    }
}
