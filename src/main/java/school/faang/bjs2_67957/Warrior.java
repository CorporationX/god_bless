package school.faang.bjs2_67957;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        log.info("Warrior {} launched an attack on {}", getName(), opponent.name);
        opponent.reduceHealth(getStrength());
    }
}