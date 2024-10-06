package school.faang.HeroesOfMightandMagic;

import lombok.Data;
import school.faang.HeroesOfMightandMagic.Creature.Creature;

import java.util.HashMap;
import java.util.Map;

@Data
public class Hero {
    private String name;
    private String fraction;
    private int exp;
    private int level;
    private final Map<Creature, Integer> army;

    public Hero(String name, String fraction, int exp, int level) {
        this.name = name;
        this.fraction = fraction;
        this.exp = exp;
        this.level = level;
        this.army = new HashMap<>();
    }

    public void addCreature(Creature creature, int quantity){
        army.put(creature, army.getOrDefault(creature, 0) + quantity);
    }

    public void removeCreature(Creature creature, int quantity){
        army.put(creature, Math.max(0, army.getOrDefault(creature, 0) - quantity));
        if (army.get(creature) == 0){
            army.remove(creature);
        }
    }

    public int getHeroPower(){
        int totalPower = 0;
        for (Map.Entry<Creature, Integer> entry : army.entrySet()) {
            totalPower += entry.getKey().getAttack() * entry.getValue() * level;
        }
        return totalPower;
    }

}
