package school.faang.heroesmandm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Hero {
    private final Map<Creature, Integer> army = new HashMap<>();

    private String name;
    private String fraction;
    private Integer experience;
    private Integer level;

    public void addCreature(Creature creature, int quantity) {
        Integer initialValue = army.containsKey(creature) ? army.get(creature) : 0;
        army.put(creature, initialValue + quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        Integer initialValue = army.containsKey(creature) ? army.get(creature) : 0;
        if(initialValue < quantity) {
            army.put(creature, initialValue - quantity);
        } else {
            army.remove(creature);
        }
    }
}