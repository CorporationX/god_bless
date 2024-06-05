package faang.school.godbless.task_003;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArcherTest {
    @Test
    void testInit() {
        // Arrange
        String name = "Legolas";
        int expStrength = 3;
        int expAgility = 10;
        int expIntelligence = 5;
        int expHealth = 100;

        // Act
        Character character = new Archer(name);

        // Assert
        int actStrength = character.getStrength();
        int actAgility = character.getAgility();
        int actIntelligence = character.getIntelligence();
        int actHealth = character.getHealth();

        assertEquals(name, character.getName(), "Name has not been established");
        assertEquals(expStrength, actStrength, "Strength has not been established");
        assertEquals(expAgility, actAgility, "Agility has not been established");
        assertEquals(expIntelligence, actIntelligence, "Intelligence has not been established");
        assertEquals(expHealth, actHealth, "Health has not been established");
    }

    @Test
    void testAttack() {
        // Arrange
        Character attacker = new Archer("Legolas");
        Character defender = new Archer("RobinHood");
        int damage = attacker.getAgility();
        int expHealth = defender.getHealth() - damage;

        // Act
        attacker.attack(defender);

        // Assert
        int actHealth = defender.getHealth();
        assertEquals(expHealth, actHealth, "There should have been 90 hp left");
    }

}
