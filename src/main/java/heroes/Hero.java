package heroes;

import heroes.item.Creature;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Hero {
    private String name;
    private int fraction;
    private int experience;
    private int level;
    private Map<String, Creature> army = new HashMap<>();

    public Hero(String name, int fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", fraction=" + fraction +
                ", experience=" + experience +
                ", level=" + level +
                ", army=" + army +
                '}';
    }

    public void addCreature(Creature creature, int quantity) {
        String creatureName = creature.getName();
        Creature creatureFromArmy = army.get(creatureName);

        if (army.containsKey(creatureName)) {
            creatureFromArmy.setQuantity(creatureFromArmy.getQuantity() + quantity);
        } else {
            creature.setQuantity(quantity);
            army.put(creatureName, creature);
        }
    }

    public void removeCreature(Creature creature, int quantity) {

        String key = creature.getName();
        int currentQuantity = army.get(key).getQuantity();

        if (army.containsKey(key)) {
            if (currentQuantity > quantity) {
                army.get(key).setQuantity(currentQuantity - quantity);
            } else army.remove(key);
        }
    }
}