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
            Creature creatureInArmy = getCreatureInArmy(newRequestedCreatureForAdding);
            creatureInArmy.setQuantity(creatureInArmy.getQuantity() + quantityForAddingInArmy);
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
            Creature creatureInArmy = getCreatureInArmy(newRequestedCreatureForRemoving);
            if (creatureInArmy.getQuantity() - quantityForRemovingInArmy <= 0) {
                this.creatures.remove(newRequestedCreatureForRemoving);
            } else {
                creatureInArmy.setQuantity(creatureInArmy.getQuantity() - quantityForRemovingInArmy);
            }
        } else {
            throw new IllegalArgumentException("This hero " + this + " doesn't contain creature " + newRequestedCreatureForRemoving + " for delete");
        }
    }

    private Creature getCreatureInArmy(Creature creatureForFound) {
        return this.creatures.get(this.creatures.indexOf(creatureForFound));
    }
}
