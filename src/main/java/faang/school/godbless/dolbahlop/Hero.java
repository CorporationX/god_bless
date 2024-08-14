package faang.school.godbless.dolbahlop;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Hero {
    private String name;
    private String fraction;
    private int expiriance;
    private int level;
    private List<Creature> army = new ArrayList<>();

    public Hero(String name, String fraction) {
        this.name = name;
        this.fraction = fraction;
    }

    public void addCreature(Creature creature, int quantity) {
        Creature existingCreature = findCreatureByType(creature.getClass());
        if (existingCreature != null) {
            updateCreatureQuantity(existingCreature, quantity);
        } else {
            addNewCreature(creature, quantity);
        }
    }

    public void removeCreature(Creature creature,int quantity) {
        Creature existingCreature = findCreatureByType(creature.getClass());
        if (existingCreature != null) {
            decriseOrRemoveCreature(existingCreature, quantity);
        }
    }

    private Creature findCreatureByType(Class<? extends Creature> creatureType) {
        for (Creature unit : army) {
            if (unit.getClass().equals(creatureType)) {
                return unit;
            }
        }
        return null;
    }

    private void updateCreatureQuantity(Creature creature, int quantity) {
        creature.setQuantity(quantity);
        army.add(creature);
    }

    private void addNewCreature(Creature creature, int quantity) {
        creature.setQuantity(quantity);
        army.add(creature);
    }

    private void decriseOrRemoveCreature(Creature creature, int quantity) {
        int newQuantity = creature.getQuantity() - quantity;
        if (newQuantity <= 0){
            army.remove(creature);
        } else {
            creature.setQuantity(newQuantity);
        }
    }

    public int calculateTotalDamage() {
        int totalDamage = 0;
        for (Creature creature : army) {
            totalDamage += creature.calculateDamage();
        }
        return totalDamage;
    }
}
