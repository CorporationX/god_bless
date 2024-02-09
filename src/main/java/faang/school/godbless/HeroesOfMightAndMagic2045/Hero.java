package faang.school.godbless.HeroesOfMightAndMagic2045;

import faang.school.godbless.HeroesOfMightAndMagic2045.Troops.Creature;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ToString
@EqualsAndHashCode
public class Hero {
    @Getter @Setter private String name;
    @Getter @Setter private String group;
    @Getter @Setter private double exp;
    @Getter @Setter private int lvl;
    private Map<Creature, Integer> army;

    public Hero(String name, String group, double exp, int lvl) {
        this.name = name;
        this.group = group;
        this.exp = exp;
        this.lvl = lvl;
        this.army = new HashMap<>();
    }

    public void addCreature(Creature creature, int quantity) {
        if (this.army.containsKey(creature)) {
            this.army.put(creature, this.army.get(creature) + quantity);
            creature.setQuantity(creature.getQuantity() + quantity);
        } else {
            this.army.put(creature, quantity);
            creature.setQuantity(quantity);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        if (this.army.containsKey(creature)) {
            if (creature.getQuantity() < quantity) {
                creature.setQuantity(0);
                this.army.put(creature, 0);
            } else {
                creature.setQuantity(creature.getQuantity() - quantity);
                this.army.put(creature, creature.getQuantity());
            }
        }
    }

    public List<Creature> getArmy() {
        List<Creature> armyList = new ArrayList<>();
        for (var entry : this.army.entrySet()) {
            entry.getKey().setQuantity(entry.getValue());
            armyList.add(entry.getKey());
        }
        return armyList;
    }
}
