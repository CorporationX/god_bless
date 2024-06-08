package faang.school.godbless.heroes_of_might_and_magic_iii;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class Hero {
    String name;
    String faction;
    int experience;
    int level;
    Map<Creature, Integer> creatures;

    public Hero(String name, String faction, int experience, int level) {
        creatures = new HashMap<>();
        this.name = name;
        this.faction = faction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        creatures.put(creature, quantity);

    }

    public void removeCreature(Creature creature, int quantity) {
        if(creatures.containsKey(creature)) {
            if(creatures.get(creature) - quantity <= 0) {
                creatures.remove(creature);
            } else {
                creatures.put(creature, creatures.get(creature) - quantity);
            }
        }
    }

    public Map<Creature, Integer> getArmy() {
        return creatures;
    }
}
