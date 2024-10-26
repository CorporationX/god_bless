package school.faang.solution.userSignUp.abstractTask;
import lombok.Data;

@Data
public abstract class Character {
    private final String name;
    private int strength;
    private int agility;
    private int intellect;
    private int hp = 100;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, int strength, int agility, int intellect) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
    }

    public abstract void attack(Character character);
}
