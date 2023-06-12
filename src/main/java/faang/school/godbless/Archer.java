package faang.school.godbless;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Archer extends Character{
    private static int STRENGTH = 3;
    private static int AGILITY = 10;
    private static int INTELLIGENCE = 5;

    public Archer(String name) {
        super(name, STRENGTH, AGILITY, INTELLIGENCE);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth()-AGILITY);
    }
}
