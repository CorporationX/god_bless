package faang.school.godbless.homm3;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Hero {
    private Map<String, Creature> army = new HashMap<>();
    private String fraction;
    private String name;
    private int experience = 0;
    private int level;

    public Hero(String name, String fraction, int level) {
        this.name = name;
        this.fraction = fraction;
        this.level = level;

    }

    public void removeCreature(Creature creature, int quantity) {
        if (army.get(creature.getName()).getQuantity() < quantity)
            throw new IllegalArgumentException("ОшЫбка, вы пытаетесь удалить существ " + creature.getName() + " больше, чем их в вашей армии");
        if (army.get(creature.getName()).getQuantity() == quantity) {
            army.remove(creature.getName());
        } else army.get(creature.getName()).setQuantity(army.get(creature.getName()).getQuantity() - quantity);

    }

    public void addCreature(Creature creature, int quantity) {
        if (army.size() > 7) {
            throw new IllegalArgumentException("ОшЫбка, армия не может быть больше 7 слотов");
        } else if (!army.containsKey(creature.getName())) {
            army.put(creature.getName(), creature);
        } else
            army.get(creature.getName()).setQuantity(army.get(creature.getName()).getQuantity() + quantity);

    }
}
