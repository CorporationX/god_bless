package faang.school.godbless.task_1;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hero {
    @Getter
    private String name;
    @Getter
    private String fraction;
    private int experience;
    private int level;
    @Getter
    private Map<String, Integer> army;
    private Map<String, Creature> listCreature;

    public Hero(String name, String fraction) {
        this.name = name;
        this.fraction = fraction;
        this.experience = 0;
        this.level = 1;
        this.army = new HashMap<>();
        this.listCreature = new HashMap<>();
    }
    public void addCreature(Creature creature, int quantity) {
        army.put(creature.getName(), army.getOrDefault(creature.getName(), 0) + quantity);
        listCreature.put(creature.getName(), creature);
    }

    public void removeCreature(Creature creature, int quantity) {
        int currentQuantity = army.getOrDefault(creature.getName(), 0);
        if (currentQuantity >= quantity) {
            army.put(creature.getName(), currentQuantity - quantity);
        } else {
            System.out.println("Not enough creatures in the army.");
        }
    }

    public Creature getCreatureByName(String name) {
        return listCreature.get(name);
    }

    public int allDamage() {
        int allDamage = 0;
        for (Map.Entry<String, Integer> entry : army.entrySet()) {
            Creature creature = getCreatureByName(entry.getKey());
            allDamage += creature.getDamage() * entry.getValue();
        }
        return allDamage;
    }
    public int allDefense() {
        int totalDefense = 0;
        for (Map.Entry<String, Integer> entry : army.entrySet()) {
            Creature creature = getCreatureByName(entry.getKey());
            totalDefense += creature.getDefense() * entry.getValue();
        }
        return totalDefense;
    }

    public String toString(){
        return getName()+" ("+getFraction()+")";
    }
}
