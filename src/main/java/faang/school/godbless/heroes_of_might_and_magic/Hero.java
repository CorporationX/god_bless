package faang.school.godbless.heroes_of_might_and_magic;

import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Hero {
    private static final int MAX_ARMY_SIZE = 7;
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army;

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
        this.army = new HashMap<>(7);
    }

    public void addCreature(@NonNull Creature creature, int quantity) {
        army.put(creature, quantity);
    }

    public void removeCreature(@NonNull Creature creature, int quantity) {
        int count = army.get(creature);

        if ((quantity - count) <= 0) {
            army.remove(creature);
        } else {
            army.put(creature, quantity - count);
        }
    }

    public Map<Creature, Integer> getArmy() {
        return army;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", fraction='" + fraction + '\'' +
                ", experience=" + experience +
                ", level=" + level +
                '}';
    }
}
