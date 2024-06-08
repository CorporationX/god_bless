package BJS2_7773;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter

abstract class  Character {
    private String name;
    protected int force;
    protected int dexterity;
    protected int intelligence;

    protected int health = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int force, int dexterity, int intelligence) {
        this.name = name;
        this.force = force;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    abstract void attack(Character character);
}
