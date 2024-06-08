package faang.school.godbless.javaCore;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private int strange;
    private int skill;
    private int intellect;
    private int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strange, int skill, int intellect) {
        this.name = name;
        this.strange = strange;
        this.skill = skill;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);

}
