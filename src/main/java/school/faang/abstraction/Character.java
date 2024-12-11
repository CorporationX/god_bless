package school.faang.abstraction;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public abstract class Character {
    private String name;
    private Integer strength;
    private Integer dexterity;
    private Integer intelligence;
    @Getter
    @Setter
    private Integer health;
    private static final int DEFAULT_HEALTH = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, Integer strength, Integer dexterity, Integer intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = DEFAULT_HEALTH;
    }

    public abstract void attack(Character character);
}
