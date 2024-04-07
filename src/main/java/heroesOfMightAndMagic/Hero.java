package heroesOfMightAndMagic;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Hero {
    private final Map<Creature, Integer> army = new HashMap<>();
    private String name;
    private String fraction;
    private int experience;
    private int level;

    public Hero(String name, String fraction) {
        this.name = name;
        this.fraction = fraction;
        this.experience = 0;
        this.level = 1;
    }

    public void addCreature(Creature creature, int quantity) {

        if (!army.containsKey(creature)) {
            army.put(creature, quantity);
        } else {
            army.put(creature, army.get(creature) + quantity);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        if (army.get(creature) - quantity < 1) {
            army.remove(creature);
        } else {
            army.put(creature, army.get(creature) - quantity);
        }
    }
}
