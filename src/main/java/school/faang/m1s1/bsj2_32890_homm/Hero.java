package school.faang.m1s1.bsj2_32890_homm;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Hero {

    private String name;
    private String town;
    private int exp;
    private int level;
    private Map<Creature, Integer> army = new HashMap<>();

    public Hero(String name, String town, int exp, int level) {
        this.name = name;
        this.town = town;
        this.exp = exp;
        this.level = level;
    }

    public void addCreature(Creature newCreature, int amount) {
        army.put(newCreature, army.computeIfAbsent(newCreature, k -> 0) + amount);
    }

    public void removeCreature(String creatureName) {
        var iterator = army.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            if (entry.getKey().getName().equals(creatureName)) {
                iterator.remove();
            }
        }
    }

    public void displayArmy() {
        System.out.printf("Hero %s (%d level) from Town %s commands following army: \n",
                this.name, this.level, this.town);
        for (var entry : army.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey().getName(), entry.getValue());
        }
    }
}
