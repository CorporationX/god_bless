package school.faang.task_43876;

import lombok.Data;

@Data
public abstract class Character {
    String name;
    int power;
    int agility;
    int intellect;
    int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int power, int agility, int intellect) {
        this.name = name;
        this.power = power;
        this.agility = power;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);
}
