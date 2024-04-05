package heroesOfMightAndMagic;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Hero {
    private final Map<String, Creature> ARMY = new HashMap<>();
    private String name;
    private String fraction;
    private int experience;
    private int level;

    public Hero(String name, String fraction) {
        this.name = name;
        this.fraction = fraction;
        this.experience = 0;
        this.level = 1;
    }

    public void addCreature(Creature creature, int quantity) {

        if (!ARMY.containsKey(creature.getName())) {
            creature.setQuantity(quantity);
            ARMY.put(creature.getName(), creature);
        } else {
            Creature tmp;
            tmp = ARMY.get(creature.getName());
            tmp.setQuantity(tmp.getQuantity() + quantity);
            ARMY.put(creature.getName(), tmp);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        Creature tmp;
        tmp = ARMY.get(creature.getName());
        if (tmp.getQuantity() - quantity < 1) {
            ARMY.remove(tmp.getName());
        } else {
            tmp.setQuantity(tmp.getQuantity() - quantity);
            ARMY.put(tmp.getName(), tmp);
        }
    }

    public Map<String, Creature> getArmy() {
        return ARMY;
    }
}
