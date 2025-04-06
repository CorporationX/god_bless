package school.faang.bjs2_68086;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Character {

    private static final int DEFAULT_VALUE = 5;

    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int health = 100;

    public Character(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public Character(String name) {
        this(name, DEFAULT_VALUE, DEFAULT_VALUE, DEFAULT_VALUE);
    }

    public abstract void attack(Character opponent);

    protected void checkIfOpponentIsKilled(Character opponent) {
        if (opponent.health < 0) {
            opponent.health = 0;
            System.out.println("Fatality");
        }
    }
}
