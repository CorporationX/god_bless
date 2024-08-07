package faang.school.godbless.BJS2_19000;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Data
public class Hero {
    private String name;
    private String fraction;
    private static final Integer EXPERIENCE = 1;
    private static final Integer LEVEL = 1;
    @Getter
    private Map<Creature, Integer> army;

    public Hero(String name, String fraction) {
        this.name = name;
        this.fraction = fraction;
        this.army = new HashMap<>();
    }

    public void addCreature(Creature creature, int quantity) {
        army.put(creature, army.getOrDefault(creature, 0) + quantity);
    }
    public void removeCreature(Creature creature, int quantity) {
        if (army.containsKey(creature)) {
            int currentQuantity = army.get(creature);
            int removeQuantity = Math.min(quantity, currentQuantity);
            if (currentQuantity <= removeQuantity) {
                army.remove(creature);
            } else {
                army.put(creature, currentQuantity - removeQuantity);
            }
        }
    }

}
