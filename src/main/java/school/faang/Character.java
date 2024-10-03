package school.faang;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private Integer force;
    private Integer skill;
    private Integer intellect;
    private Integer hitPoints = 100;

    public Character(String name, Integer force, Integer skill, Integer intellect) {
        this.name = name;
        this.force = force;
        this.skill = skill;
        this.intellect = intellect;
    }

    public Character(String name) {
        this.name = name;
    }

    public abstract void attack(Character character);
}
