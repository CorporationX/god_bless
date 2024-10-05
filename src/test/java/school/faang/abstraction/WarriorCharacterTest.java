package school.faang.abstraction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WarriorCharacterTest {

    Character archer;
    Character warrior;

    @BeforeEach
    void setUp() {
        archer = new Archer("Legolas");
        warrior = new Warrior("Ork");
    }

    @Test
    void attackMethodTest() {
        archer.attack(warrior);
        warrior.attack(archer);
        assertEquals(90, warrior.health);
        assertEquals(90, archer.health);
    }
}
