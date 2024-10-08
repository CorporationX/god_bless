package school.faang.BJS2_32875;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Hero {
    private String name;
    private String fraction;
    private int exp;
    private int level;
    private Map<Creature, Integer> army = new HashMap<>();

    public Hero(String name, String fraction, int exp, int level) {
        this.name = name;
        this.fraction = fraction;
        this.exp = exp;
        this.level = level;
    }

    public void addCreature(Creature newCreature, int quantity) {
        army.put(newCreature, army.computeIfAbsent(newCreature, k -> 0) + quantity);
    }

    public void removeCreature(String creatureName) {
        army.entrySet().removeIf(entry -> entry.getKey().getName().equals(creatureName));
    }

    public void printArmy() {
        System.out.println("Hero " + this.name + " commands following army:");
        for (var entry : army.entrySet()) {
            Creature creature = entry.getKey();
            System.out.println(creature.getName() + ": " + entry.getValue());
        }
    }
}