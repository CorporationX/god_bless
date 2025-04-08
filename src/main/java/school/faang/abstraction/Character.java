package school.faang.abstraction;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@EqualsAndHashCode
@ToString
public abstract class Character {

    public static final int MAX_XP = 100;
    public static final int BASIC_CHARACTER = 5;

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int health = MAX_XP;

    public Character(@NonNull String name) {
        this.name = name;
        setStrength(BASIC_CHARACTER);
        setAgility(BASIC_CHARACTER);
        setIntelligence(BASIC_CHARACTER);
    }

    public abstract void attack(Character opponent);

    public void deathHero() {
        if (this.health <= 0) {
            throw new NullPointerException("Герой погиб");
        }
    }
}