import abstraction.Character;
import abstraction.Warrior;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WarriorTest {
    @Test
    @DisplayName("Testing attack on other character")
    void warriorTest_testingAttack() {
        Warrior warrior = new Warrior("Malakat");
        Character enemy = new Warrior("Konan");

        warrior.attack(enemy);

        assertEquals(100 - warrior.getStrength(), enemy.getHealth());
    }

    @Test
    @DisplayName("Testing health below zero after attack")
    void warriorTest_testingBelowZeroHealth() {
        Warrior warrior = new Warrior("Malakat");
        Character enemy = new Warrior("Konan");

        for (int i = 0; i < 15; i++) {
            warrior.attack(enemy);
        }

        assertEquals(0, enemy.getHealth());
    }

    @Test
    @DisplayName("Testing attack null enemy")
    void warriorTest_testingAttackNullEnemy() {
        Warrior warrior = new Warrior("Malakat");
        Character enemy = null;

        assertThrows(NullPointerException.class, () -> warrior.attack(enemy));
    }
}
