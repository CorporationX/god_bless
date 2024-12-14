package faang.school.godbless.heroes.core.sprint;

import faang.school.godbless.heroes.core.sprint.creature.Creature;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Getter
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;

    private final Map<String, Creature> nameCreatureMap = new HashMap<>();

    public void addCreature(Creature creature, int quantity) {
        nameCreatureMap.merge(creature.getName(), creature.addQuantity(quantity),
                (oldCreature, newCreature) -> oldCreature.addQuantity(quantity));
    }

    public void removeCreature(Creature creature, int quantity) {
        nameCreatureMap.merge(creature.getName(), creature.removeQuantity(quantity),
                (oldCreature, newCreature) -> oldCreature.removeQuantity(quantity));
    }

    public void removeCreature(Creature creature) {
        nameCreatureMap.remove(creature.getName());
    }

    public void updateCreature(Creature creature) {
        nameCreatureMap.put(creature.getName(), creature);
    }

    public Set<String> getArmy() {
        return nameCreatureMap.keySet();
    }

    public Map<String, Creature> getCreatures() {
        return nameCreatureMap;
    }

    public boolean hasArmy() {
        return !getCreatures().isEmpty();
    }

}
