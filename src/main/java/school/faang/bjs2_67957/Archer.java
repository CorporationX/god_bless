package school.faang.bjs2_67957;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        log.info("Archer {} launched an attack on {}", getName(), opponent.name);
        opponent.reduceHealth(getAgility());
    }
}
