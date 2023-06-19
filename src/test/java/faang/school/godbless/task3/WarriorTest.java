package faang.school.godbless.task3;

import faang.school.godbless.task3.Character;
import faang.school.godbless.task3.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    @Test
    void archerConstructorTest() {
        Character warrior = new Warrior("Warrior");
        assertAll(() -> {
            assertEquals(warrior.getName(), "Warrior");
            assertEquals(warrior.getStrength(), 10);
            assertEquals(warrior.getAgility(), 5);
            assertEquals(warrior.getIntelligence(), 3);
            assertEquals(warrior.getHealth(), 100);
        });
    }

    @Test
    void attack_shouldReduceEnemyHealthByTen() {
        Character enemy = new Warrior("Enemy");
        assertEquals(enemy.getHealth(), 100);
        Character warrior = new Warrior("Warrior");
        warrior.attack(enemy);
        assertEquals(enemy.getHealth(), 90);
    }
}