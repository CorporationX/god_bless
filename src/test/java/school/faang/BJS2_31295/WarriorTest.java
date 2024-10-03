package school.faang.BJS2_31295;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WarriorTest {
    @Test
    @DisplayName("Testing the creation of Warrior object using constructor with valid name")
    void testWarrior_OnlyNameConstructorInitializationValidName() {
        //arrange
        String name = "Anna";
        int expectedPower = 10;
        int expectedAgility = 5;
        int expectedIntelligence = 3;
        int expectedHealth = 100;

        //act
        Warrior anna = new Warrior(name);

        //assert
        assertEquals(name, anna.name);
        assertEquals(expectedPower, anna.power);
        assertEquals(expectedAgility, anna.agility);
        assertEquals(expectedIntelligence, anna.intelligence);
        assertEquals(expectedHealth, anna.health);
    }

    @Test
    @DisplayName("Testing the creation of Warrior object using constructor with empty name")
    void testWarrior_OnlyNameConstructorInitializationEmptyName() {
        //arrange
        String name = "    ";

        //act + assert
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new Warrior(name));
        assertEquals("Invalid name.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing the creation of Warrior object using constructor with null name")
    void testWarrior_OnlyNameConstructorInitializationNullName() {
        //arrange
        String name = null;

        //act + assert
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new Warrior(name));
        assertEquals("Invalid name.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing character damage")
    void testWarrior_WarriorAttack() {
        //arrange
        Character warrior = new Warrior("warrior");
        Character archer = new Archer("archer");
        int expectedArcherHealth = 90;

        //act
        warrior.attack(archer);

        //assert
        assertEquals(expectedArcherHealth, archer.health);
    }
}