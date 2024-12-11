package school.faang.sprint_1.task_bjs43864;

import static school.faang.sprint_1.task_bjs43864.BattleConfig.WARRIOR_AGILITY;
import static school.faang.sprint_1.task_bjs43864.BattleConfig.WARRIOR_INTELLIGENCE;
import static school.faang.sprint_1.task_bjs43864.BattleConfig.WARRIOR_POWER;


public class Warrior extends Character {

    public Warrior(String name) {
        super(name, WARRIOR_POWER, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    void attack(Character character) {
        character.setHealth(character.getHealth() - getPower());
    }
}
