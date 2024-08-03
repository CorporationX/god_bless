package faang.school.godbless;

import faang.school.godbless.units.Creature;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Hero {

    private String name;
    private String fraction;
    private int experience;
    private int level;
    private List<Creature> creatures = new ArrayList<>();

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity couldn't be less than 1");
        }

        if (this.creatures.contains(creature)) {
            this.creatures.stream().filter(c -> c.getName().equalsIgnoreCase(creature.getName())).map(c -> {
                c.setQuantity(c.getQuantity() + quantity);
                return null;
            }).count();
        } else {
            creature.setQuantity(quantity);
            this.creatures.add(creature);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity couldn't be less than 1");
        }

        if (this.creatures.contains(creature)) {
            this.creatures.stream().filter(c -> c.getName().equalsIgnoreCase(creature.getName())).map(c -> {
                if (c.getQuantity() - quantity <= 0) {
                    removeCreature(creature);
                } else {
                    c.setQuantity(c.getQuantity() - quantity);
                }
                return null;
            }).count();
        } else {
            throw new IllegalArgumentException("This hero " + this + " doesn't contain creature " + creature + " for delete");
        }
    }

    public void removeCreature(Creature creature) {
        if (this.creatures.contains(creature)) {
            this.creatures.remove(creature);
        } else {
            throw new IllegalArgumentException("This hero " + this + " doesn't contain creature " + creature + " for delete");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }

    public void setCreatures(List<Creature> creatures) {
        this.creatures = creatures;
    }
}
