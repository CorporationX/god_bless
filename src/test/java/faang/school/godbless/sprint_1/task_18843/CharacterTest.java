package faang.school.godbless.sprint_1.task_18843;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    private static final Character WARRIOR = new Warrior("Warrior");
    private static final Character ARCHER = new Archer("Archer");

    @Test
    void testWarriorAttack() {
        assertEquals(100, ARCHER.getHealth());

        WARRIOR.attack(ARCHER);
        assertEquals(90, ARCHER.getHealth());

        WARRIOR.setStrength(89);
        WARRIOR.attack(ARCHER);
        assertEquals(1, ARCHER.getHealth());
    }

    @Test
    void testArcherAttack() {
        assertEquals(100, WARRIOR.getHealth());

        ARCHER.attack(WARRIOR);
        assertEquals(90, WARRIOR.getHealth());

        ARCHER.setDexterity(89);
        ARCHER.attack(WARRIOR);
        assertEquals(1, WARRIOR.getHealth());
    }
}