import abstraction.Character;
import abstraction.Archer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArcherTest {
    @Test
    @DisplayName("Testing attack on other character")
    void warriorTest_testingAttack() {
        Archer archer = new Archer("Legolas");
        Character enemy = new Archer("Hawkeye");

        archer.attack(enemy);

        assertEquals(100 - archer.getAgility(), enemy.getHealth());
    }

    @Test
    @DisplayName("Testing health below zero after attack")
    void warriorTest_testingBelowZeroHealth() {
        Archer archer = new Archer("Legolas");
        Character enemy = new Archer("Hawkeye");

        for (int i = 0; i < 15; i++) {
            archer.attack(enemy);
        }

        assertEquals(0, enemy.getHealth());
    }

    @Test
    @DisplayName("Testing attack null enemy")
    void warriorTest_testingAttackNullEnemy() {
        Archer archer = new Archer("Legolas");
        Character enemy = null;

        assertThrows(NullPointerException.class, () -> archer.attack(enemy));
    }
}
