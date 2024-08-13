package heroes.of.might.and.magic;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    @Getter
    private final Map<Creature, Integer> army = new HashMap<>();

    public void addCreature(Creature creature, int quantity) {
        if (this.army.containsKey(creature)) {
            Integer creatureQuantity = this.army.get(creature);
            this.army.put(creature, quantity + creatureQuantity);
        }

        this.army.put(creature, quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        if (this.army.containsKey(creature)) {
            Integer creatureQuantity = this.army.get(creature);
            if (creatureQuantity - quantity <= 0) {
                this.army.remove(creature);
            } else {
                this.army.put(creature, creatureQuantity - quantity);
            }
        }
    }
}
