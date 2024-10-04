package school.faang.homm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army;

    public void addCreature(Creature creature, int quantity) {
        army.put(creature, army.getOrDefault(creature, 0) + quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        if (army.containsKey(creature)) {
            Integer currentQuantity = army.get(creature);
            if (currentQuantity - quantity <= 0) {
                army.remove(creature);
            } else {
                army.put(creature, currentQuantity - quantity);
            }
        }
    }

    public List<Creature> getArmy() {
        return army.keySet().stream().toList();
    }
}
