package school.faang.t02;
import lombok.Getter;

@Getter
public class Archer extends Character {

    private int power = 3;
    private int dexterity = 10;
    private int intelligence = 5;

    @Override
    void attack(Character character) {
        character.health = character.health - getDexterity();
    }

    public Archer(String name) {
        super(name);
    }
}

