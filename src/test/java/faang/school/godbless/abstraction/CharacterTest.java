package faang.school.godbless.abstraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CharacterTest {
    private Character warrior;
    private Character archer;

    @BeforeEach
    void setUp() {
        warrior = new Warrior("Warrior");
        archer = new Archer("Archer");
    }

    @Test
    void warriorAttackTest() {
        warrior.attack(archer);
        warrior.attack(archer);
        assertEquals(80, archer.health);
    }

    @Test
    void archerAttackTest() {
        archer.attack(warrior);
        archer.attack(warrior);
        archer.attack(warrior);
        assertEquals(70, warrior.health);
    }

    @Test
    void warriorDeadTest() {
        for (int i = 0; i < 10; i++) {
            archer.attack(warrior);
        }
        assertThrows(RuntimeException.class, () -> archer.attack(warrior));
    }

    @Test
    void archerDeadTest() {
        for (int i = 0; i < 10; i++) {
            warrior.attack(archer);
        }
        assertThrows(RuntimeException.class, () -> warrior.attack(archer));
    }
}
