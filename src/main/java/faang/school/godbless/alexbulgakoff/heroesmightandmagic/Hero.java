package faang.school.godbless.alexbulgakoff.heroesmightandmagic;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Alexander Bulgakov
 */

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Hero {

    private String name;
    private String fraction;
    private int experience;
    private int level;

    private Map<Creature, Integer> heroArmy;

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
        this.heroArmy = new HashMap<>();
    }

    public void addCreature(Creature creature, int quantity) {
        heroArmy.put(creature, quantity);
    }

    public void removeCreature(Creature creature, int quantity) {
        heroArmy.remove(creature);
    }

    public List<Creature> getArmy() {
        List<Creature> creatureList = new ArrayList<>();

        for (Map.Entry<Creature, Integer> entry : heroArmy.entrySet()) {
            creatureList.add(entry.getKey());
        }

        return creatureList;
    }
}
