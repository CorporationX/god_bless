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
}
