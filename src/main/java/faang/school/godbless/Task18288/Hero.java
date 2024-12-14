package faang.school.godbless.Task18288;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Hero {

    private String name;
    private String faction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army = new HashMap<>();

    public Hero(String name, String faction, int experience, int level) {
        this.name = name;
        this.faction = faction;
        this.experience = experience;
        this.level = level;
    }


    public void addCreature(Creature creature, int quantity) {
        army.put(creature, army.getOrDefault(creature, 0) + quantity);
    }


    public void removeCreature(Creature creature, int quantity) {
        int currentQuantity = army.getOrDefault(creature, 0);

        if (currentQuantity > 0) {
            int newQuantity = currentQuantity - quantity;

            if (newQuantity <= 0) {
                army.remove(creature);
            } else {
                army.put(creature, newQuantity);
            }
        }
    }


    public List<Creature> getArmy() {
        List<Creature> armyList = new ArrayList<>();

        army.forEach((creature, quantity) -> {
            for (int i = 0; i < quantity; i++) {
                armyList.add(creature);
            }
        });

        return armyList;
    }
}