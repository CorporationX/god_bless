package faang.school.godbless.BJS27979;

import faang.school.godbless.BJS27979.Creatures.Creature;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class Hero {
    private String name;
    private String faction;
    private int level;
    private Map<Creature, Integer> army;

    public void addCreature(Creature creature, int quantity) {
        army.merge(creature, quantity, Integer::sum);
        creature.setOwner(this);
        creature.updateTotalHealth(quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        army.merge(creature, -quantity, Integer::sum);
        creature.updateTotalHealth(-quantity);
    }

    public int getArmyCost() {
        return army.entrySet()
                .stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public int attack(Creature creature) {

    }
}
