package faang.school.godbless.domain;

import lombok.Data;

@Data
public abstract class Character {

    protected String name;
    protected Integer power;
    protected Integer agility;
    protected Integer intellect;
    protected Integer healthy = 100;

    Character(String name, Integer power, Integer agility, Integer intellect) {
        this.name = name;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);
}
