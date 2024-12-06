package school.faang.task_43848;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Warrior extends Character {

    public Warrior(String name) {
        super(name, CharactersStats.WARRIOR_STRENGTH, CharactersStats.WARRIOR_AGILITY, CharactersStats.WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character defender) {
        log.info(name + " attacks " + defender.name);
        int healthAfterAttack = defender.getHealth() - strength;
        defender.setHealth(healthAfterAttack);
    }
}
