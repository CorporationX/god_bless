package school.faang.bjs2_68146;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character character) {
        int damage = getStrength();
        log.info("{} attacks {} for {} damage.", getName(), character.getName(), damage);
        character.takeDamage(damage);
    }
}
