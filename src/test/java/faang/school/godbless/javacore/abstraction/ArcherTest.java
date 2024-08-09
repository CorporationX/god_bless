package faang.school.godbless.javacore.abstraction;

import org.junit.jupiter.api.Test;

import static faang.school.godbless.javacore.abstraction.Character.DEFAULT_HEALTH_VALUE;
import static org.junit.jupiter.api.Assertions.*;

class ArcherTest {

    @Test
    void testAttack() {
        Archer archer = new Archer("Archer");
        Archer archerEnemy = new Archer("ArcherEnemy");

        archer.attack(archerEnemy);

        assertEquals(DEFAULT_HEALTH_VALUE - Archer.AGILITY, archerEnemy.getHealth());
    }
}