package faang.school.godbless.dolbahlop;

import faang.school.godbless.dolbahlop.Abstractions.Warrior;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
public class WarriorTest {
    @ParameterizedTest
    @CsvSource({
            "Conan, 10, 5, 3, 100",
    })
    void testWarriorInitialization(String name, int strength, int agility, int intelligence, int health) {
        // Arrange
        Warrior warrior = new Warrior(name);

        // Act
        String actualName = warrior.getName();
        int actualStrength = warrior.getStrength();
        int actualAgility = warrior.getAgility();
        int actualIntelligence = warrior.getIntelligence();
        int actualHealth = warrior.getVitality();

        // Assert
        assertEquals(name, actualName, "Name should be initialized correctly");
        assertEquals(strength, actualStrength, "Strength should be initialized correctly");
        assertEquals(agility, actualAgility, "Agility should be initialized correctly");
        assertEquals(intelligence, actualIntelligence, "Intelligence should be initialized correctly");
        assertEquals(health, actualHealth, "Health should be initialized to default value");
    }
}
