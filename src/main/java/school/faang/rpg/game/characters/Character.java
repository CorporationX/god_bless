package school.faang.rpg.game.characters;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public abstract class Character {

    public static final Integer STRENGTH = 5;
    public static final Integer AGILITY = 5;
    public static final Integer INTELLIGENCE = 5;
    public static final Integer HEALTH = 100;

    private final String name;
    private final Integer strength;
    private final Integer agility;
    private final Integer intelligence;
    private Integer health = HEALTH;

    public Character(String name) {
        this.strength = STRENGTH;
        this.agility = AGILITY;
        this.intelligence = INTELLIGENCE;
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
