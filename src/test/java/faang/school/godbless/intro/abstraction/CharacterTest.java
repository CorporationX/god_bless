package faang.school.godbless.intro.abstraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CharacterTest {
    Character warrior;
    Character archer;

    @BeforeEach
    void setUp() {
        warrior = new Warrior("Arthur");
        archer = new Archer("Robin");
    }

    @Test
    void testConstructorWithValidParameters() {
        assertNotNull(warrior);
        assertEquals("Arthur", warrior.getName());
        assertEquals(10, warrior.getForce());
        assertEquals(5, warrior.getAgility());
        assertEquals(3, warrior.getIntellect());
        assertEquals(100, warrior.getHealth());

        assertNotNull(archer);
        assertEquals("Robin", archer.getName());
        assertEquals(3, archer.getForce());
        assertEquals(10, archer.getAgility());
        assertEquals(5, archer.getIntellect());
        assertEquals(100, archer.getHealth());
    }

    @Test
    void testTakeDamage() {
        warrior.takeDamage(10);
        assertEquals(90, warrior.getHealth());
        archer.takeDamage(15);
        assertEquals(85, archer.getHealth());
    }

    @Test
    void testAttack() {
        warrior.attack(archer);
        assertEquals(90, archer.getHealth());
        archer.attack(warrior);
        assertEquals(90, warrior.getHealth());

    }
}