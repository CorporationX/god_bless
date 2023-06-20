package faang.school.godbless.sprint2.task3;

import faang.school.godbless.sprint2.task3.Archer;
import faang.school.godbless.sprint2.task3.Character;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherTest {
    @Test
    void archerConstructorTest() {
        Character archer = new Archer("Archer");
        assertAll(() -> {
            assertEquals(archer.getName(), "Archer");
            assertEquals(archer.getStrength(), 3);
            assertEquals(archer.getAgility(), 10);
            assertEquals(archer.getIntelligence(), 5);
            assertEquals(archer.getHealth(), 100);
        });
    }

    @Test
    void attack_shouldReduceEnemyHealthByThree() {
        Character enemy = new Archer("Enemy");
        assertEquals(enemy.getHealth(), 100);
        Character archer = new Archer("Archer");
        archer.attack(enemy);
        assertEquals(enemy.getHealth(), 97);
    }
}