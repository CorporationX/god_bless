package school.faang.bjs2_68112;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public abstract class Character {
    private static final Integer DEFAULT_STRENGTH = 5;
    private static final Integer DEFAULT_AGILITY = 5;
    private static final Integer DEFAULT_INTELLECT = 5;

    private String name;
    @Getter
    private Integer strength;
    @Getter
    private Integer agility;
    private Integer intellect;
    @Setter
    @Getter
    private Integer health = 100;

    public Character(String name) {
        this(name, DEFAULT_STRENGTH, DEFAULT_AGILITY, DEFAULT_INTELLECT);
    }

    public Character(String name, Integer strength, Integer agility, Integer intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character opponent);

    protected void diminishHealth(Integer amount) {
        health = Math.max(0, health - amount);
    }
}
