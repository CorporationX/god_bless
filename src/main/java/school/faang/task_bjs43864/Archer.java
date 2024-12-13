package school.faang.task_bjs43864;

import static school.faang.task_bjs43864.BattleConfig.ARCHER_AGILITY;
import static school.faang.task_bjs43864.BattleConfig.ARCHER_INTELLIGENCE;
import static school.faang.task_bjs43864.BattleConfig.ARCHER_POWER;

public class Archer extends Character {

    public Archer(String name) {
        super(name, ARCHER_POWER, ARCHER_AGILITY, ARCHER_INTELLIGENCE);
    }

    @Override
    void attack(Character character) {
        character.setHealth(character.getHealth() - getAgility());
    }
}
