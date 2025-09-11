package school.faang.rpg.game.characters;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.ToString;

@ToString
public abstract class Character {
    protected String name;
    protected Integer strength;
    protected Integer agility;
    protected Integer intelligence;
    @Getter
    protected Integer health = 100;

    public Character(String name) {
        this.strength = 5;
        this.agility = 5;
        this.intelligence = 5;
        this.name = name;
    }

    public Character(String name, Integer strength, Integer agility, Integer intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    protected void reduceHealth(Integer damage) {
        health = Math.max(0, health - damage);
    }

    public abstract void attack(Character opponent);
}
