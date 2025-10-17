package school.faang.BJS2_85677;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {
    private String name;
    private int strength;
    private int agility;
    private int intellect;
    private int health = 100;

    public Character(String name) {
        this.name = name;
        setStrength(5);
        setAgility(5);
        setIntellect(5);
    }

    public Character(int intellect, int agility, int strength, String name) {
        this.intellect = intellect;
        this.agility = agility;
        this.strength = strength;
        this.name = name;
    }

    public void healthLevelChecking(Character character) {
        if (character.health < 0) {
            character.health = 0;
        }
    }

    public void attack(Character opponent) {
        System.out.println("Битва началась");
    }
}
