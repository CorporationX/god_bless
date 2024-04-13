package faang.school.godbless.hashMap.task_7.model.heroes;

import faang.school.godbless.hashMap.task_7.model.creatures.Creature;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Hero {
    private static final int MAX_NUMBER_OF_UNITS = 4;
    private final String name;
    private final String fraction;
    private int experience;
    private int level;
    private final List<Creature> army = new ArrayList<>(MAX_NUMBER_OF_UNITS);

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        if (army.size() < MAX_NUMBER_OF_UNITS) {
            creature.increaseQuantity(quantity);
            army.add(creature);
        } else {
            throw new IllegalStateException("В армии нет места");
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        int quantityAfterDamage = creature.decreaseQuantity(quantity);
        if (quantityAfterDamage == 0 || creature.getSquadHealth() <= 0) {
            removeSquadFromArmy(creature);
        }
    }

    public void removeSquadFromArmy(Creature creature) {
        army.remove(creature);
        System.out.println("отряд " +  creature + " убит");
    }

    public List<Creature> getArmy() {
        return army;
    }

    public boolean isDefeated() {
        return  army.isEmpty();
    }
}