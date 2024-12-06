package school.faang.task_43848;

import lombok.extern.slf4j.Slf4j;

import static school.faang.task_43848.GameConfig.WARRIOR_STRENGTH;
import static school.faang.task_43848.GameConfig.WARRIOR_AGILITY;
import static school.faang.task_43848.GameConfig.WARRIOR_INTELLIGENCE;

@Slf4j
public class Warrior extends Character {

    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character defender) {
        log.info(this.getName() + " attacks " + defender.getName());
        int healthAfterAttack = defender.getHealth() - this.getStrength();
        defender.setHealth(healthAfterAttack);
    }
}
