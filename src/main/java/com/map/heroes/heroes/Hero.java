package com.map.heroes.heroes;

import com.map.heroes.units.Creature;
import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Data
@Getter
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;

    private Map<Creature, Integer> creaturesMap = new HashMap<>();

    public Hero(String name, String fraction, int experience, int level) {
        if (!name.isEmpty() && !fraction.isEmpty() && experience > 0 && level > 0) {
            this.name = name;
            this.fraction = fraction;
            this.experience = experience;
            this.level = level;
        } else {
            throw new IllegalArgumentException("Argument is not valid");
        }
    }

    public void addCreature(Creature creature, int quantity) {
        if (quantity > 0) {
            creaturesMap.put(creature, quantity);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        if (quantity > 0 && creature.getQuantity() >= quantity) {
            creaturesMap.put(creature, creaturesMap.get(creature) - quantity);
        }

    }

    public void getArmy() {
        for (Map.Entry<Creature, Integer> entry : creaturesMap.entrySet()) {
            System.out.println("Unit: " + entry.getKey().getName() + " quantity: " + entry.getValue());
        }
    }

    public Map<Creature, Integer> getCreaturesMap() {
        return creaturesMap;
    }

    private boolean checkCreature(Creature creature) {
        return creaturesMap.containsKey(creature);
    }

}
