package faang.school.godbless.heroesOfMigthAndMagic;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Hero {
    private String name;
    private String fraction;
    private double exp;
    private int level;

    private final Map<Creature, Integer> army = new HashMap<>();


    public void addCreature(Creature creature, int quantity) {
        if (!army.containsKey(creature)) {
            army.put(creature, quantity);
        } else {
            int newQuantity = army.get(creature) + quantity;
            army.put(creature, newQuantity);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        if (!army.containsKey(creature)) {
            int newQuantity = army.get(creature) - quantity;
            if (newQuantity < 0) {
                army.remove(creature);
            } else {
                army.put(creature, newQuantity);
            }
        } else {
            System.out.println("Creature not found.");
        }
    }
    public void printArmy(){
        System.out.println(name + "'s, army:");
        army.forEach((key, value)-> System.out.println(key.getName()+ ", quantity:"+value));
    }
}

