package school.faang.BJS2_31295;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArcherTest {
    @Test
    @DisplayName("Testing the creation of Archer object using constructor with valid name")
    void testArcher_OnlyNameConstructorInitializationValidName() {
        //arrange
        String name = "Anna";
        int expectedPower = 3;
        int expectedAgility = 10;
        int expectedIntelligence = 5;
        int expectedHealth = 100;

        //act
        Archer anna = new Archer(name);

        //assert
        assertEquals(name, anna.name);
        assertEquals(expectedPower, anna.power);
        assertEquals(expectedAgility, anna.agility);
        assertEquals(expectedIntelligence, anna.intelligence);
        assertEquals(expectedHealth, anna.health);
    }

    @Test
    @DisplayName("Testing the creation of Archer object using constructor with empty name")
    void testArcher_OnlyNameConstructorInitializationEmptyName() {
        //arrange
        String name = "    ";

        //act + assert
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new Archer(name));
        assertEquals("Invalid name.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing the creation of Archer object using constructor with null name")
    void testArcher_OnlyNameConstructorInitializationNullName() {
        //arrange
        String name = null;

        //act + assert
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new Archer(name));
        assertEquals("Invalid name.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing Archer damage")
    void testArcher_ArcherAttack() {
        //arrange
        Character warrior = new Warrior("warrior");
        Character archer = new Archer("archer");
        int expectedArcherHealth = 90;

        //act
        archer.attack(warrior);

        //assert
        assertEquals(expectedArcherHealth, warrior.health);
    }
}