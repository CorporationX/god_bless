package school.faang.t02;
import lombok.Getter;

@Getter
public class Warrior extends Character {

    private int power = 10;
    private int dexterity = 5;
    private int intelligence = 3;

    @Override
    void attack(Character character) {
        character.health = character.health - getPower();
    }

    public Warrior(String name) {
        super(name);
    }
}

