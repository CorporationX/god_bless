package school.faang.BJS2_32861_HeroesOfMightAndMagic;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Hero {
    private String name;
    private String faction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army = new HashMap<>();

    public Hero(String name, String faction, int experience, int level) {
        this.name = name;
        this.faction = faction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        validateCreature(creature);
        validateQuantity(quantity);
        army.merge(creature, quantity, Integer::sum);
    }

    public void removeCreature(Creature creature, int quantity) {
        validateCreature(creature);
        validateQuantity(quantity);
        army.put(creature, Math.max(army.getOrDefault(creature, 0) - quantity, 0));
    }

    private void validateCreature(Creature creature) {
        if (creature == null)
            throw new IllegalArgumentException("Creature can't be null.");
    }

    private void validateQuantity(int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity of creatures must be at least 1.");
    }
}
