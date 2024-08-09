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

    public void addCreature(Creature newRequestedCreatureForAdding, int quantityForAddingInArmy) {
        if (quantityForAddingInArmy <= 0) {
            throw new IllegalArgumentException("Quantity argument couldn't be less than 1");
        }

        if (this.creatures.contains(newRequestedCreatureForAdding)) {
            this.creatures.stream()
                    .filter(c -> c.getName().equalsIgnoreCase(newRequestedCreatureForAdding.getName()))
                    .map(c -> {
                        c.setQuantity(c.getQuantity() + quantityForAddingInArmy);
                        return null;
                    })
                    .count();
        } else {
            newRequestedCreatureForAdding.setQuantity(quantityForAddingInArmy);
            this.creatures.add(newRequestedCreatureForAdding);
        }
    }

    public void removeCreature(Creature newRequestedCreatureForRemoving, int quantityForRemovingInArmy) {
        if (quantityForRemovingInArmy <= 0) {
            throw new IllegalArgumentException("Quantity argument couldn't be less than 1");
        }

        if (this.creatures.contains(newRequestedCreatureForRemoving)) {
            this.creatures.stream()
                    .filter(c -> c.getName().equalsIgnoreCase(newRequestedCreatureForRemoving.getName()))
                    .map(c -> {
                        if (c.getQuantity() - quantityForRemovingInArmy <= 0) {
                            removeCreature(newRequestedCreatureForRemoving);
                        } else {
                            c.setQuantity(c.getQuantity() - quantityForRemovingInArmy);
                        }
                        return null;
                    })
                    .count();
        } else {
            throw new IllegalArgumentException("This hero " + this + " doesn't contain creature " + newRequestedCreatureForRemoving + " for delete");
        }
    }

    public void removeCreature(Creature creature) {
        if (this.creatures.contains(creature)) {
            this.creatures.remove(creature);
        } else {
            throw new IllegalArgumentException("This hero " + this + " doesn't contain creature " + creature + " for delete");
        }
    }
}
