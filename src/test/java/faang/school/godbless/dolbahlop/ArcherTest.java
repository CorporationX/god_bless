package faang.school.godbless.dolbahlop;

import faang.school.godbless.dolbahlop.Abstractions.Archer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
public class ArcherTest {
    @ParameterizedTest
    @CsvSource({
            "Legolas, 3, 10, 5, 100",
    })
    void testArcherInitialization(String name, int strength, int agility, int intelligence, int health) {
        // Arrange
        Archer archer = new Archer(name);

        // Act
        String actualName = archer.getName();
        int actualStrength = archer.getStrength();
        int actualAgility = archer.getAgility();
        int actualIntelligence = archer.getIntelligence();
        int actualHealth = archer.getVitality();

        // Assert
        assertEquals(name, actualName, "Name should be initialized correctly");
        assertEquals(strength, actualStrength, "Strength should be initialized correctly");
        assertEquals(agility, actualAgility, "Agility should be initialized correctly");
        assertEquals(intelligence, actualIntelligence, "Intelligence should be initialized correctly");
        assertEquals(health, actualHealth, "Health should be initialized to default value");
    }
}
