package school.faang.BJS2_31295;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArcherTest {
    @Test
    @DisplayName("Testing the creation of Archer object using constructor (only name) with valid name")
    void testConstructorWithValidNameOnly() {
        String name = "Anna";
        int expectedPower = 3;
        int expectedAgility = 10;
        int expectedIntelligence = 5;
        int expectedHealth = 100;

        Archer anna = new Archer(name);

        assertEquals(name, anna.name);
        assertEquals(expectedPower, anna.power);
        assertEquals(expectedAgility, anna.agility);
        assertEquals(expectedIntelligence, anna.intelligence);
        assertEquals(expectedHealth, anna.health);
    }

    @Test
    @DisplayName("Testing the creation of Archer object using constructor (only name) with empty name")
    void testConstructorWithEmptyNameOnly() {
        String name = "    ";

        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new Archer(name));
        assertEquals("Invalid name.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing the creation of Archer object using constructor (only name) with null name")
    void testConstructorWithNullNameOnly() {
        String name = null;

        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> new Archer(name));
        assertEquals("Invalid name.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing the damage given by a Archer to another character")
    void testArcherAttack() {
        Character warrior = new Warrior("warrior");
        Character archer = new Archer("archer");
        int expectedArcherHealth = 90;

        archer.attack(warrior);

        assertEquals(expectedArcherHealth, warrior.health);
    }
}