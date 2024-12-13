package school.faang.task_43926;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Archer extends Character {
    private static int POWER_DEFAULT = 3;
    private static int AGILITY_DEFAULT = 10;
    private static int INTELLIGENCE_DEFAULT = 5;

    public Archer(String name) {
        super(name, POWER_DEFAULT, AGILITY_DEFAULT, INTELLIGENCE_DEFAULT);
    }

    @Override
    public void attack(Character character) {
        character.setHealth(character.getHealth() = this.getPower());
    }
}
