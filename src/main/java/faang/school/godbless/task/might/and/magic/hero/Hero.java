package faang.school.godbless.task.might.and.magic.hero;

import faang.school.godbless.task.might.and.magic.creature.Creature;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@ToString
@AllArgsConstructor
public class Hero {
    private String name;
    private String fraction;
    private double experience;
    private int level;
    private Map<String, Creature> army;

    public void addCreature(Creature creature, int quantity) {
        creature.setQuantity(quantity);
        army.put(creature.getName(), creature);
    }

    public void removeCreature(Creature creature, int quantity) {
        var creatureForUpdate = army.get(creature.getName());
        int currentQuantity = creatureForUpdate.getQuantity();
        if (currentQuantity > quantity) {
            creatureForUpdate.setQuantity(currentQuantity - quantity);
        } else {
            army.remove(creature.getName());
        }
    }

    public List<Creature> getArmy() {
        return army.values().stream().collect(Collectors.toList());
    }
}
