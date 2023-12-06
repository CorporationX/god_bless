package faang.school.godbless.BJS2_511;

import faang.school.godbless.BJS2_511.creatures.Creature;
import lombok.Data;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.ArrayList;

@Data
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    Map<Creature, Integer> army = new HashMap<>();

    public  Hero (String name, String fraction) {
        this.name = name;
        this.fraction = fraction;
        this.experience = 0;
        this.level = 1;
    }

    public void addCreature (Creature creature, int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("quantity must be more then 0");

        army.put(creature, army.getOrDefault(creature, 0) + quantity);
    }

    public void removeCreature (Creature creature, int quantity) {
        if (quantity <= 0)
            throw new IllegalArgumentException("quantity must be more then 0");

        army.compute(creature, (key, currentQuantity) -> {
            if(currentQuantity == null) return null;
            int newQuantity = currentQuantity - quantity;
            return newQuantity <= 0 ? null : newQuantity;
        });
    }

    public List<Creature> getArmy () {
        if (army == null || army.isEmpty())
            throw new NoSuchElementException("You dont have army yet!");

        List<Creature> creatureList = new ArrayList<>();

        army.forEach((creature, quantity) -> {
            for (int i = 0; i < quantity; i++) {
                creatureList.add(creature);
            }
        });

        return creatureList;
    }
}
