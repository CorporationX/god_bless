package school.faang.abstraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherTest {
    private Archer attacker;

    @BeforeEach
    public void setUp() {
        attacker = new Archer("Леголас");
    }

    @Test
    @DisplayName("Проверка нанесения урона лучником")
    void testAttack() {
        //arrange
        Character defender = new Warrior("Азог");
        int expectedHealth = 90;

        //act
        attacker.attack(defender);
        int healthAfterAttack = defender.getHealth();

        //assert
        assertEquals(expectedHealth, healthAfterAttack);
    }
}