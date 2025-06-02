package school.faang.bjs2_79166;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 10, 5, 3);
    }

    @Override
    public void attack(Character opponent) {
        if (isKilled(opponent.health, strength)) {
            opponent.health = 0;
            log.info("{} is killed", opponent.name);
        } else {
            log.info("{} наносит урон {} равный {}", this.name, opponent.name, this.strength);
            opponent.health -= this.strength;
        }
    }
}
