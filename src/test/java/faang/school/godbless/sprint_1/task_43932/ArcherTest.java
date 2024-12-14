package faang.school.godbless.sprint_1.task_43932;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArcherTest {

    private static final Warrior WARRIOR = new Warrior("Warrior");
    private static final Archer ARCHER = new Archer("Archer");

    private static final int WARRIOR_FULL_HEALTH = WARRIOR.getHealth();

    private static final int ARCHER_DEXTERITY = 10;

    @Test
    void testAttack() {
        ARCHER.attack(WARRIOR);
        assertEquals(WARRIOR_FULL_HEALTH - ARCHER_DEXTERITY, WARRIOR.getHealth());
    }
}