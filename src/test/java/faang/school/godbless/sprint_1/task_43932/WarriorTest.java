package faang.school.godbless.sprint_1.task_43932;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarriorTest {

    private static final Warrior WARRIOR = new Warrior("Warrior");
    private static final Archer ARCHER = new Archer("Archer");

    private static final int ARCHER_FULL_HEALTH = WARRIOR.getHealth();

    private static final int WARRIOR_STRENGTH = 10;

    @Test
    void testAttack() {
        WARRIOR.attack(ARCHER);
        assertEquals(ARCHER_FULL_HEALTH - WARRIOR_STRENGTH, ARCHER.getHealth());
    }
}
