package faang.school.godbless.sword_magic;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public abstract class Creature {
    protected String name;
    protected int level;
    protected int attack;
    protected int armor;
    protected int speed;
    protected int quantity;
    public Creature(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public int getDamage(){
        return attack * speed;
    }

    @Override
    public String toString() {
        return "Name - " + name + "Level - " + level;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Creature creature)) {
            return false;
        }

        if (getLevel() != creature.getLevel()) {
            return false;
        }
        if (getAttack() != creature.getAttack()) {
            return false;
        }
        if (getArmor() != creature.getArmor()) {
            return false;
        }
        if (getSpeed() != creature.getSpeed()) {
            return false;
        }
        return getName().equals(creature.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level);
    }
}
