package game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {
    private Warrior warrior;
    private Archer archer;

    @BeforeEach
    void setUp() {
        warrior = new Warrior("Sword");
        archer = new Archer("Bow");
    }

    @Test
    void warriorAttackTest() {
        warrior.attack(archer);
        assertEquals(90, archer.getHealth(), "Archer should lose 10 health after Warrior attack");
    }

    @Test
    void archerAttackTest() {
        archer.attack(warrior);
        assertEquals(90, warrior.getHealth(), "Warrior should lose 10 health after Archer attack");
    }

    @Test
    void healthCannotGoBelowZeroTest() {
        for (int i = 0; i < 11; i++) {
            warrior.attack(archer);
        }
        assertEquals(0, archer.getHealth(), "Health should not drop below 0");
    }

    @Test
    void lowerBoundaryHealthTest() {
        for (int i = 0; i < 10; i++) {
            warrior.attack(archer);
        }
        assertEquals(0, archer.getHealth(), "Health should be 0 at boundary condition");
    }

    @Test
    void upperBoundaryHealthTest() {
        archer.attack(warrior);
        assertEquals(90, warrior.getHealth(), "Upper boundary health after one attack");
    }
}
