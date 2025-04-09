package school.faang.bjs2_68146;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character character) {
        int damage = getAgility();
        log.info("{} attacks {} for {} damage.", getName(), character.getName(), damage);
        character.takeDamage(damage);
    }
}