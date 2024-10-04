package bjs2_31309;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {
    Warrior warrior;
    Warrior warrior1;
    Warrior warrior2;
    Archer archer;
    Archer archer1;
    Archer archer2;

    @BeforeEach
    void setUp() {
        warrior = new Warrior("George");
        warrior1 = new Warrior("Bob");
        warrior2 = new Warrior("Jack");
        archer = new Archer("Sam");
        archer1 = new Archer("Chad");
        archer2 = new Archer("Jermaine");
    }

    @Test
    @DisplayName("Test warrior attack")
    public void testWarriorAttack() {
        // arrange
        int expectedArcherHealth = 90;

        // act
        warrior.attack(archer);

        // assert
        assertEquals(expectedArcherHealth, archer.getHealth());
    }

    @Test
    @DisplayName("Test archer attack")
    public void testArcherAttack() {
        // arrange
        int expectedWarriorHealth = 90;

        // act
        archer.attack(warrior);

        // assert
        assertEquals(expectedWarriorHealth, warrior.getHealth());
    }

    @Test
    @DisplayName("Test two warriors against 1 archer")
    public void testTwoWarriorsAttack() {
        // arrange
        int expectedArcherHealth = 80;

        // act
        warrior.attack(archer);
        warrior1.attack(archer);

        //assert
        assertEquals(expectedArcherHealth, archer.getHealth());
    }

    @Test
    @DisplayName("Test two warriors attack 2 archers")
    void testTwoWarriorsAttackTwoArchers() {
        // arrange
        int firstArcherExpectedHealth = 90;
        int secondArcherExpectedHealth = 90;

        // act
        warrior.attack(archer);
        warrior1.attack(archer1);

        // assert
        assertEquals(firstArcherExpectedHealth, archer.getHealth());
        assertEquals(secondArcherExpectedHealth, archer1.getHealth());
    }

    @Test
    @DisplayName("Test warrior vs warrior")
    void testWarriorVsWarrior() {
        // arrange
        int firstWarriorExpectedHealth = 90;
        int secondWarriorExpectedHealth = 90;

        // act
        warrior.attack(warrior1);
        warrior1.attack(warrior);

        // assert
        assertEquals(firstWarriorExpectedHealth, warrior1.getHealth());
        assertEquals(secondWarriorExpectedHealth, warrior.getHealth());
    }

    @Test
    @DisplayName("Test archer vs archer")
    void testArcherVsArcher() {
        // arrange
        int firstWarriorExpectedHealth = 90;
        int secondWarriorExpectedHealth = 90;

        // act
        archer.attack(archer1);
        archer1.attack(archer);

        // assert
        assertEquals(firstWarriorExpectedHealth, archer1.getHealth());
        assertEquals(secondWarriorExpectedHealth, archer.getHealth());
    }

    @Test
    @DisplayName("Test three warriors vs one archer")
    void testThreeWarriorsAttack() {
        // arrange
        int expectedArcherHealth = 70;

        // act
        warrior.attack(archer);
        warrior1.attack(archer);
        warrior2.attack(archer);

        // assert
        assertEquals(expectedArcherHealth, archer.getHealth());
    }

    @Test
    @DisplayName("Test three archers vs one warrior")
    void testThreeArchersAttack() {
        // arrange
        int expectedWarriorHealth = 70;

        // act
        archer.attack(warrior);
        archer1.attack(warrior);
        archer2.attack(warrior);

        // assert
        assertEquals(expectedWarriorHealth, warrior.getHealth());
    }

    @Test
    @DisplayName("Multiple attackers")
    void testMultipleAttacks() {
        // arrange
        int firstWarriorExpectedHealth = 80;
        int secondWarriorExpectedHealth = 90;
        int thirdWarriorExpectedHealth = 90;
        int firstArcherExpectedHealth = 70;
        int secondArcherExpectedHealth = 100;
        int thirdArcherExpectedHealth = 100;

        // act
        warrior.attack(archer);
        warrior.attack(archer);
        warrior1.attack(archer);
        archer.attack(warrior1);
        warrior2.attack(warrior);
        archer2.attack(warrior);
        archer1.attack(warrior2);

        // assert
        assertEquals(firstWarriorExpectedHealth, warrior.getHealth());
        assertEquals(secondWarriorExpectedHealth, warrior1.getHealth());
        assertEquals(thirdWarriorExpectedHealth, warrior2.getHealth());
        assertEquals(firstArcherExpectedHealth, archer.getHealth());
        assertEquals(secondArcherExpectedHealth, archer1.getHealth());
        assertEquals(thirdArcherExpectedHealth, archer2.getHealth());
    }
}
