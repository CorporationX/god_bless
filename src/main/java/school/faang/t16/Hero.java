package school.faang.t16;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
class Hero {
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
        army.put(creature, army.getOrDefault(creature, 0) + quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        int currentQuantity = army.getOrDefault(creature, 0);
        if (currentQuantity <= quantity) {
            army.remove(creature);
        } else {
            army.put(creature, currentQuantity - quantity);
        }
    }

    public Map<Creature, Integer> getArmy() {
        return new HashMap<>(army);
    }
}