package HeroesOfMightAndMagic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Hero {
    private String name;
    private Map<Creature, Integer> fraction;
    private int experience;
    private int level;

    public Hero(String name, int experience, int level) {
        this.name = name;
        this.experience = experience;
        this.level = level;
        this.fraction = new HashMap<>();
    }

    public void addCreature(Creature creature, int quantity) {
        if (fraction.containsKey(creature)) {
            int quantityCreature = fraction.get(creature);
            quantity += quantityCreature;
        }
        fraction.put(creature, quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        if (fraction.containsKey(creature)) {
            int quantityCreature = fraction.get(creature);
            if (quantityCreature <= quantity) {
                fraction.remove(creature);
            } else {
                fraction.put(creature, quantityCreature - quantity);
            }
        } else {
            System.out.println("В армии героя " + this.name + " нет ни одного существа " + creature.getName());
        }
    }

    public void getArmy() {
        System.out.println("Армия героя " + this.name + ":");
        for (Map.Entry<Creature, Integer> entry : fraction.entrySet()) {
            System.out.println(entry.getKey().getName() + " (" + entry.getValue() + ")");
        }
    }
}

