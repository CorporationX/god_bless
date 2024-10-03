package bjs2_31309;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {
    Warrior warrior;
    Archer archer;

    @BeforeEach
    void setUp() {
        warrior = new Warrior("George");
        archer = new Archer("Sam");
    }

    @Test
    @DisplayName("Test warrior attack")
    public void testWarriorAttack() {
        // arrange
        int expectedArcherHealth = 90;

        // act
        warrior.attack(archer);

        // assert
        assertEquals(expectedArcherHealth, archer.health);
    }

    @Test
    @DisplayName("Test archer attack")
    public void testArcherAttack() {
        // arrange
        int expectedWarriorHealth = 90;

        // act
        archer.attack(warrior);

        // assert
        assertEquals(expectedWarriorHealth, warrior.health);
    }
}
