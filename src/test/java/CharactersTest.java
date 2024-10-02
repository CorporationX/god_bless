import org.junit.jupiter.api.Test;
import school.faang.Characters.Archer;
import school.faang.Characters.Character;
import school.faang.Characters.Warrior;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharactersTest {

    @Test
    public void testConstructors() {
        // arrange
        Character archer = new Archer("Hawkeye");
        Character warrior = new Warrior("Guts");

        // asset
        assertEquals("Hawkeye", archer.getName(), "The name should be Hawkeye");
        assertEquals("Guts", warrior.getName(), "The name should be Guts");

        assertEquals(3, archer.getStrength(), "Strength should be 3");
        assertEquals(10, archer.getAgility(), "Agility should be 10");
        assertEquals(5, archer.getIntellect(), "Intellect should be 5");

        assertEquals(10, warrior.getStrength(), "Strength should be 10");
        assertEquals(5, warrior.getAgility(), "Agility should be 5");
        assertEquals(3, warrior.getIntellect(), "Intellect should be 3");
    }

    @Test
    public void testAttack() {
        // arrange
        Character archer = new Archer("Hawkeye");
        Character warrior = new Warrior("Guts");

        // act
        archer.attack(warrior);
        archer.attack(warrior);
        warrior.attack(archer);

        // assert
        assertEquals(80, warrior.getHealth(), "Warrior's health after two attacks should be 80.");
        assertEquals(90, archer.getHealth(), "Archer's health after one attack should be 90.");
    }
}
