package faang.school.godbless.task_003;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarriorTest {

    @Test
    void testInit() {
        // Arrange
        String name = "Barbarian";
        int expStrength = 10;
        int expAgility = 5;
        int expIntelligence = 3;
        int expHealth = 100;

        // Act
        Character character = new Warrior(name);

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
    void testTakeDamage() {
        // Arrange
        Character defender = new Warrior("Knight");
        int damage = 10;
        int expHealth = defender.getHealth() - damage;

        // Act
        defender.takeDamage(damage);

        // Assert
        int actHealth = defender.getHealth();
        assertEquals(expHealth, actHealth, "There should have been 90 hp left");

    }

    @Test
    void testHealthBelowZero() {
        // Arrange
        Character defender = new Warrior("Knight");
        int damage = 110;
        int expHealth = 0;

        // Act
        defender.takeDamage(damage);

        // Assert
        int actHealth = defender.getHealth();
        assertEquals(expHealth, actHealth, "There should have been 0 hp left");

    }

    @Test
    void testAttack() {
        // Arrange
        Character attacker = new Warrior("Barbarian");
        Character defender = new Warrior("Knight");
        int damage = attacker.getStrength();
        int expHealth = defender.getHealth() - damage;

        // Act
        attacker.attack(defender);

        // Assert
        int actHealth = defender.getHealth();
        assertEquals(expHealth, actHealth, "There should have been 90 hp left");
    }
}
