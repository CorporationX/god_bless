package school.faang.bjs2_79166;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Archer extends Character {
    public Archer(String name) {
        super(name, 3, 10, 5);
    }

    @Override
    public void attack(Character opponent) {
        if (isKilled(opponent.health, agility)) {
            health = 0;
            log.info("{} is killed", opponent.name);
        } else {
            log.info("{} наносит урон {} равный {}", this.name, opponent.name, this.agility);
            opponent.health -= this.agility;
        }
    }
}
