package school.faang.task_43848;

import lombok.extern.slf4j.Slf4j;

import static school.faang.task_43848.GameConfig.ARCHER_STRENGTH;
import static school.faang.task_43848.GameConfig.ARCHER_AGILITY;
import static school.faang.task_43848.GameConfig.ARCHER_INTELLIGENCE;

@Slf4j
public class Archer extends Character {

    public Archer(String name) {
        super(name, ARCHER_STRENGTH, ARCHER_AGILITY, ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character defender) {
        log.info(this.getName() + " attacks " + defender.getName());
        int healthAfterAttack = defender.getHealth() - this.getAgility();
        defender.setHealth(healthAfterAttack);
    }
}
