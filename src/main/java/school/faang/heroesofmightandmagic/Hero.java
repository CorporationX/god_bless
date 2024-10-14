package school.faang.heroesofmightandmagic;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;

@Data
public class Hero {
    private String name;
    private String faction;
    private int experience;
    private int level;
    private Map<String, Creature> army;

    public Hero(String name, String faction) {
        this.name = name;
        this.faction = faction;
        this.experience = 0;
        this.level = 1;
        this.army = new HashMap<>();
    }

    // Method to add creatures to the hero's army
    public void addCreature(Creature creature, int quantity) {
        if (army.containsKey(creature.getName())) {
            army.get(creature.getName()).setQuantity(army.get(creature.getName()).getQuantity() + quantity);
        } else {
            creature.setQuantity(quantity);
            army.put(creature.getName(), creature);
        }
    }

    // Method to remove creatures from the hero's army
    public void removeCreature(Creature creature, int quantity) {
        if (army.containsKey(creature.getName())) {
            int currentQuantity = army.get(creature.getName()).getQuantity();
            int newQuantity = Math.max(currentQuantity - quantity, 0);
            if (newQuantity == 0) {
                army.remove(creature.getName());
            } else {
                army.get(creature.getName()).setQuantity(newQuantity);
            }
        }
    }

    // Method to get the list of all creatures in the hero's army
    public Map<String, Creature> getArmy() {
        return army;
    }
}
