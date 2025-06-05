package school.faang.module1.bjs2_79178;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Warrior extends Character {

    private static final int WARRIOR_STRENGTH = 10;
    private static final int WARRIOR_AGILITY = 5;
    private static final int WARRIOR_INTELLIGENCE = 3;

    public Warrior(String name) {
        super(name, WARRIOR_STRENGTH, WARRIOR_AGILITY, WARRIOR_INTELLIGENCE);
    }

    @Override
    public void attack(Character opponent) {
        log.info("{} наносит удар {}", name, opponent.getName());
        opponent.takeDamage(strength);
    }
}
