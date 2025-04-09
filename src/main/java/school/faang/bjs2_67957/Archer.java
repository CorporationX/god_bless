package school.faang.bjs2_67957;

import lombok.extern.slf4j.Slf4j;

import static school.faang.bjs2_67957.GameProperties.ARCHER_AGILITY;
import static school.faang.bjs2_67957.GameProperties.ARCHER_INTELLIGENCE;
import static school.faang.bjs2_67957.GameProperties.ARCHER_STRENGTH;

@Slf4j
public class Archer extends Character {
    public Archer(String name) {
        super(name, ARCHER_STRENGTH, ARCHER_AGILITY, ARCHER_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        log.info("Archer {} launched an attack on {}", getName(), opponent.getName());
        opponent.reduceHealth(getAgility());
    }
}
