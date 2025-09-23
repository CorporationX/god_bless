package school.faang.bjs2_86611;

import lombok.Getter;

@Getter
public abstract class Character {
    public String name;
    public int power;
    public int agility;
    public int intellect;
    public int health = 100;

    public Character(String name) {
        this.name = name;
        this.power = 5;
        this.agility = 5;
        this.intellect = 5;
    }

    public Character(String name, int power, int agility, int intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character opponent);

    public void inAttack(int damage) {
        this.checkHealth(this.health);
        this.health = this.health - damage;
    }

    public boolean checkHealth(int health) {
        return health <= 0;
    }
}
