package school.faang.abstraction;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public abstract class Character {

    private static final int DEFAULT_HEALTH = 100;

    private String name;
    private Integer strength;
    private Integer dexterity;
    private Integer intelligence;
    private Integer health;

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

    public void setHealth(Integer health) {
        if (health < 0) {
            throw new IllegalArgumentException("Health cannot be less than 0!");
        }
        this.health = health;
    }
}
