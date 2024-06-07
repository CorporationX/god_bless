package faang.school.godbless.hero;

import faang.school.godbless.creation.Creature;
import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private Map<Creature, Integer> heroArmy = new HashMap<>();

    public Hero(String name, String fraction, int level, int experience) {
        this.name = name;
        this.fraction = fraction;
        this.level = level;
        this.experience = experience;
    }

    public Map<Creature, Integer> addCreature(Creature creature, int quantity) {
        if (creature == null || quantity == 0) {
            throw new IllegalArgumentException();
        }
        if (heroArmy.containsKey(creature)) {
            heroArmy.put(creature, heroArmy.get(creature) + quantity);
        } else {
            heroArmy.put(creature, quantity);
        }
        return heroArmy;
    }

    public Map<Creature, Integer> removeCreature(Creature creature, int quantity) {
        if (creature == null || quantity == 0) {
            throw new IllegalArgumentException();
        }
        if (heroArmy.containsKey(creature)) {
            if (heroArmy.get(creature) < quantity) {
                heroArmy.remove(creature);
            } else {
                heroArmy.put(creature, heroArmy.get(creature) - quantity);
            }
        } else {
            throw new IllegalArgumentException();
        }
        return heroArmy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return experience == hero.experience && level == hero.level && Objects.equals(name, hero.name) && Objects.equals(fraction, hero.fraction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fraction, experience, level);
    }
}
