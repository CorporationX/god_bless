package faang.school.godbless;

import lombok.Data;

@Data
public abstract class Character {
    private String name;
    private int force;
    private int dexterity;
    private int intelligence;
    private int health = 100;

    public Character(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public Character(String name, int intelligence, int dexterity, int force) {
        this(name);

        if (intelligence < 0 || dexterity < 0 || force < 0) {
            throw new IllegalArgumentException("Attributes cannot be negative");
        }

        this.intelligence = intelligence;
        this.dexterity = dexterity;
        this.force = force;
    }

    public void attack(Character opponent){
        if (opponent == null) {
            throw new IllegalArgumentException("Opponent cannot be null");
        }
    };

}


