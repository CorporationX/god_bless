package Mathew;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Hero {
    private String name;
    private String fraction;
    private int exp;
    private int lvl;
    private Map<Integer,Creature> heroArmy = new HashMap<>();
    public void addCreature(Creature creature, int quantity) {
heroArmy.put(quantity,creature);
    }
    public void removeCreature(Creature creature, int quantity) {
        heroArmy.remove(quantity);
    }
    public void getArmy() {
        for(Map.Entry<Integer,Creature> entry : heroArmy.entrySet()) {
            System.out.println("Количество:" + entry.getKey() + " Тип войск:" + entry.getValue());
        }
    }
    public int getTotalAttack() {
        int totalAttack = 0;
        for (Map.Entry<Integer, Creature> entry : heroArmy.entrySet()) {
            int quantity = entry.getKey();
            Creature creature = entry.getValue();
            totalAttack += creature.getAttack() * quantity;
        }
        return totalAttack;
    }

}
