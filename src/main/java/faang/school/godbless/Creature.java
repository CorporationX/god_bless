package faang.school.godbless;

import java.util.Objects;

public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int armor;
    private int speed;
    private int quality;

    public Creature(String name, int level, int attack, int armor, int speed, int quality) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.armor = armor;
        this.speed = speed;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getAttack() {
        return attack;
    }

    public int getArmor() {
        return armor;
    }

    public int getSpeed() {
        return speed;
    }

    public int getQuality() {
        return quality;
    }

    public abstract int getDamage();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return level == creature.level && attack == creature.attack && armor == creature.armor && speed == creature.speed && quality == creature.quality && Objects.equals(name, creature.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, attack, armor, speed, quality);
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", attack=" + attack +
                ", armor=" + armor +
                ", speed=" + speed +
                ", quality=" + quality +
                '}';
    }
}
