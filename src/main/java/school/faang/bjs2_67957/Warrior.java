package school.faang.bjs2_67957;

import lombok.extern.slf4j.Slf4j;

import static school.faang.bjs2_67957.GameProperties.WARRIOR_AGILITY;
import static school.faang.bjs2_67957.GameProperties.WARRIOR_INTELLIGENCE;
import static school.faang.bjs2_67957.GameProperties.WARRIOR_STRENGTH;

@Slf4j
public class Warrior extends Character {
    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        log.info("Warrior {} launched an attack on {}", getName(), opponent.getName());
        opponent.reduceHealth(getStrength());
    }
}