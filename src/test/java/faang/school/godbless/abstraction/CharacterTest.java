package faang.school.godbless.abstraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    Character warrior;
    Character archer;
    @BeforeEach
    void setUp() {
        warrior = new Warrior("Warrior");
        archer = new Archer("Archer");
    }

    @Test
    void testAttackWarrior() {
        warrior.attack(archer);
        assertEquals(90, archer.getHealth());
    }

    @Test
    void testAttackArcher() {
        archer.attack(warrior);
        assertEquals(90, warrior.getHealth());
    }

    @Test
    void testInflictDamage() {
        warrior.inflictDamage(20);
        assertEquals(80, warrior.getHealth());
    }
}