package faang.school.godbless.BJS218880;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;
import java.util.Map;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Hero {

    String name;
    String fraction;
    int experience;
    int level;
    Map<String, Creature> creatures;

    public Hero(String name, String fraction, int experience, int level, Map<String, Creature> creatures) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
        this.creatures = creatures;

        if (experience < 1 || level < 1 || fraction.isEmpty() || name.isEmpty() || creatures.isEmpty()) {
            throw new IllegalArgumentException("Invalid Hero");
        }
    }

    public void addCreature(Creature creature) {
        if (creatures.containsKey(creature.getName())) {
            int quantity = creatures.get(creature.getName()).getQuantity();
            creatures.get(creature.getName()).setQuantity(quantity + creature.getQuantity());
        } else {
            creatures.put(creature.getName(), creature);
        }
    }

    public void removeCreature(Creature creature) {
        if (creatures.containsKey(creature.getName())) {
            int quantity = creatures.get(creature.getName()).getQuantity();
            if (quantity > creature.getQuantity()) {
                creatures.get(creature.getName()).setQuantity(quantity - creature.getQuantity());
            } else {
                creatures.remove(creature.getName());
            }
        }
    }

    public Map<String, Creature> getArmy(){
        if (!creatures.isEmpty()){
            return creatures;
        }else {
            return new HashMap<>();
        }
    }

}
