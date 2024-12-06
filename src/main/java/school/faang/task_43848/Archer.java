package school.faang.task_43848;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Archer extends Character {

    public Archer(String name) {
        super(name, GameConfig.ARCHER_STRENGTH, GameConfig.ARCHER_AGILITY, GameConfig.ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character defender) {
        log.info(name + " attacks " + defender.name);
        int healthAfterAttack = defender.getHealth() - agility;
        defender.setHealth(healthAfterAttack);
    }
}
