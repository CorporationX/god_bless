package school.BJS2_32836;

import lombok.Getter;
import lombok.Setter;

public abstract class Creature {

    @Getter
    protected String name;
    protected int lvl;
    protected int attack;
    protected int protect;
    protected int speed;
    @Getter
    @Setter
    protected int health = 100;

    protected abstract int getDamage();

    protected void attackEnemy(Creature creature) {
        creature.setHealth(creature.getHealth() - getDamage());
    }

    public Creature(String name, int lvl, int attack, int protect, int speed) {
        this.name = name;
        this.lvl = lvl;
        this.attack = attack;
        this.protect = protect;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "lvl=" + lvl +
                ", name='" + name + '\'' +
                ", attack=" + attack +
                ", protect=" + protect +
                ", speed=" + speed +
                '}';
    }
}