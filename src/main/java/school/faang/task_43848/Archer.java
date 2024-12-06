package school.faang.task_43848;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Archer extends Character {

    public Archer(String name) {
        super(name, CharactersStats.ARCHER_STRENGTH, CharactersStats.ARCHER_AGILITY, CharactersStats.ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character defender) {
        log.info(name + " attacks " + defender.name);
        int healthAfterAttack = defender.getHealth() - agility;
        defender.setHealth(healthAfterAttack);
    }
}
