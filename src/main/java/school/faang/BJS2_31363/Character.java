package school.faang.BJS2_31363;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {

    final int MAX_HEALTH = 100;

    protected String name;
    protected int power;
    protected int agility;
    protected int intelligence;
    protected int health = MAX_HEALTH;

    public Character(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        if(health <= 0) {
            System.out.println(name + " is dead");
        }
        return health > 0;
    }

    public Character(String name, int power, int agility, int intelligence) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void setHealth(int health) {
        if (health > MAX_HEALTH) {
            this.health = MAX_HEALTH;
        }
        else this.health = Math.max(health, 0);
    }
    public abstract void attack(Character Enemy);
}
