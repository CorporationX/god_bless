package faang.school.godbless.heroes_of_might_and_magic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class Creature {
    private String name;
    private int level;
    private int damage;
    private int defence;
    private int speed;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return level == creature.level && damage == creature.damage && defence == creature.defence && speed == creature.speed && Objects.equals(name, creature.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, damage, defence, speed);
    }
}
