package faang.school.godbless.javacore.abstraction;

import org.junit.jupiter.api.Test;

import static faang.school.godbless.javacore.abstraction.Character.DEFAULT_HEALTH_VALUE;
import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    @Test
    void testAttack() {
        Warrior warrior = new Warrior("Warrior");
        Warrior warriorEnemy = new Warrior("WarriorEnemy");

        warrior.attack(warriorEnemy);

        assertEquals(DEFAULT_HEALTH_VALUE - Warrior.STRENGTH, warriorEnemy.getHealth());
    }
}