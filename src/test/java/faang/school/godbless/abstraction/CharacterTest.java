package faang.school.godbless.abstraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CharacterTest {

    private static final String CHARACTER_NAME = "CHARACTER_NAME";
    private static final String ENEMY_NAME = "ENEMY_NAME";
    private static final int EXPECTED_HEALTH = 90;

    private Character character;
    private Character enemy;

    @Test
    public void whenWarriorDamageByStrength() {
        character = new Warrior(CHARACTER_NAME);
        enemy = new Archer(ENEMY_NAME);
        character.attack(enemy);

        assertEquals(EXPECTED_HEALTH, enemy.getHealth());
    }

    @Test
    public void whenArcherDamageByAgility() {
        character = new Archer(CHARACTER_NAME);
        enemy = new Warrior(ENEMY_NAME);
        character.attack(enemy);

        assertEquals(EXPECTED_HEALTH, enemy.getHealth());
    }
}