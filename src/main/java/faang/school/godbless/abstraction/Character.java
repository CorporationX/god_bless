package faang.school.godbless.abstraction;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public abstract class Character {

    private String name;
    private Integer strength;
    private Integer agility;
    private Integer intelligence;
    private Integer health;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Integer strength, Integer agility, Integer intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = 100;
    }

    public abstract void attack(Character character);
}
