package school.faang.heroes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@ToString
public class Hero {
    @ToString.Exclude
    private final Map<Creature, Integer> army = new HashMap<>();

    private String name;
    private String fraction;
    private int experience;
    private int level;

    public void addCreature(Creature creature, int quantity) {
        army.merge(creature, quantity, Integer::sum);
    }

    public void removeCreature(Creature creature, int quantity) {
        if (!army.containsKey(creature)) {
            return;
        }
        int currentQuantity = army.get(creature);
        if (quantity >= currentQuantity) {
            army.remove(creature);
            return;
        }
        army.put(creature, currentQuantity - quantity);
    }

    public List<Creature> getCreatures() {
        return new ArrayList<>(army.keySet());
    }
}
