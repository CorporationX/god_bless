package school.faang.task_43957;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {
    private static final int MAX_HEALTH = 100;
    private String name;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health = MAX_HEALTH;

    protected Character(String name) {
        this.name = name;
    }

    protected Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    protected abstract void attack(Character character);

    protected void setHealth(int health) {
        if (health >= 1 && health <= MAX_HEALTH) {
            this.health = health;
        } else if (health < 1) {
            this.health = health;
            throw new IllegalArgumentException(" is dead");
        } else {
            throw new IllegalArgumentException("Health cannot exceed " + MAX_HEALTH);
        }
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", health=" + health +
                '}';
    }
}



