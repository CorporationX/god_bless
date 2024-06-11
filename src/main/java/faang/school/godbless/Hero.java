package faang.school.godbless;

import lombok.*;

import java.util.Map;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Hero {
    private String name;
    private String faction;
    private int experience;
    private int level;
    @Setter
    private Map<Creature, Integer> army;

    void addCreature(Creature creature, int quantity) {
        this.army.put(creature, quantity);
    }

    void removeCreature(Creature creature, int quantity) {
        if (quantity >= this.army.get(creature)) {
            this.army.remove(creature);
        } else {
            this.army.putIfAbsent(creature, this.army.get(creature) - quantity);
        }
    }
}
