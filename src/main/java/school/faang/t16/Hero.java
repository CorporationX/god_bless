package school.faang.t16;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

class Hero {
    @Getter
    private String name;
    private String faction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army;

    public Hero(String name, String faction) {
        this.name = name;
        this.faction = faction;
        this.experience = 0;
        this.level = 1;
        this.army = new HashMap<>();
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