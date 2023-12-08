package faang.school.godbless.task_1;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Getter
@Setter
public class Hero {
    private static final int MAX_SIZE_ARMY = 7;

    protected String name;
    protected String fraction;
    protected int experience;
    protected int level;
    protected Map<String, Integer> army = new HashMap<>();
    protected List<String> listArmy = new ArrayList<>(MAX_SIZE_ARMY);


    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(String creature, int quantity) throws IllegalAccessException {
        if (quantity <= 0) {
            throw new IllegalAccessException("Quantity must be positive {name +" + name + ", quantity= " + quantity + "}");
        }
        if (listArmy.size() < MAX_SIZE_ARMY) {
            army.merge(creature, quantity, Integer::sum);
            listArmy.add(creature);
        } else {
            throw new IllegalAccessException("Cannot add more creatures, army is at max size");
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        String creatureName = creature.enumNameAndAttack.getName();
        if (army.containsKey(creatureName)) {
            int creatureQuantity = army.get(creatureName);
            int newCreatureQuantity = creatureQuantity - quantity;
            if (newCreatureQuantity > 0) {
                army.put(creatureName, newCreatureQuantity);
            } else {
                army.remove(creatureName);
                listArmy.remove(creatureName);
            }
        }
    }

    public List<String> getArmy() {
        return listArmy;
    }

    public static int getCreatureAtrack(String creatureName) {
        switch (creatureName) {
            case "Swordman":
                return 2;
            case "Pikeman":
                return 3;
            case "Griffin":
                return 5;
            case "Angel":
                return 8;
            default:
                return 0;
        }
    }

    protected static int StrongArmy(Hero hero) {
        int strong = 0;
        for (Map.Entry<String, Integer> entry : hero.army.entrySet()) {
            String unitName = entry.getKey();
            int unitQuantity = entry.getValue();
            int unitGetAttack = Hero.getCreatureAtrack(unitName);
            strong += unitGetAttack * unitQuantity;
        }
        return strong;
    }
}
