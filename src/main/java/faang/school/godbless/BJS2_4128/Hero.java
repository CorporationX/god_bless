package faang.school.godbless.BJS2_4128;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Hero {
    private String name;
    private String faction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army = new HashMap<>();

    public Hero(String name, String faction) {
        this.name = name;
        this.faction = faction;
        this.experience = 0;
        this.level = 1;
    }

    public void addCreature(Creature creature, int quantity) {
        army.put(creature, getCreatureQuantity(creature) + quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        int currentQuantity = army.getOrDefault(creature, 0);

        if (currentQuantity <= quantity) {
            army.remove(creature);
        } else {
            army.put(creature, currentQuantity - quantity);
        }
    }

    public List<Creature> getArmy() {
        List<Creature> result = new ArrayList<>();

        for (Map.Entry<Creature, Integer> entry : army.entrySet()) {
            result.add(entry.getKey());
        }

        return result;
    }

    public Integer getCreatureQuantity(Creature creature) {
        return army.getOrDefault(creature, 0);
    }

    public void setCreatureQuantity(Creature creature, Integer quantity) {
        if (quantity == 0) {
            army.remove(creature);
        } else {
            army.put(creature, Math.max(quantity, 0));
        }
    }
}
