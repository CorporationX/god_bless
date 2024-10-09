package school.faang.abstraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    private Warrior attacker;

    @BeforeEach
    public void setUp() {
        attacker = new Warrior("Азог");
    }

    @Test
    @DisplayName("Проверка нанесения урона воином")
    void testAttack() {
        //arrange
        Character defender = new Archer("Леголас");
        int expectedHealth = 90;

        //act
        attacker.attack(defender);
        int healthAfterAttack = defender.getHealth();

        //assert
        assertEquals(expectedHealth, healthAfterAttack);
    }
}