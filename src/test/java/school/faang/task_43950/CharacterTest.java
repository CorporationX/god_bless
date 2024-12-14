package school.faang.task_43950;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharacterTest {

    @Test
    @DisplayName("Constructor: should initialize fields correctly")
    void constructor_shouldInitializeFieldsCorrectly() {
        Archer archer = new Archer("Archer");
        Warrior warrior = new Warrior("Warrior");

        assertAll("Character initialization",
                () -> assertEquals("Archer", archer.name, "Archer's name should be correct"),
                () -> assertEquals(10, archer.agility, "Archer's agility should be 10"),
                () -> assertEquals(10, warrior.strength, "Warrior's strength should be 10"),
                () -> assertEquals(100, archer.health, "Initial health should be 100")
        );
    }

    @Test
    @DisplayName("Attack: Archer attacks Warrior and reduces health")
    void attack_shouldReduceTargetHealth() {
        Archer archer = new Archer("Legolas");
        Warrior warrior = new Warrior("Conan");

        int initialHealth = warrior.health;
        archer.attack(warrior);

        assertEquals(initialHealth - 10, warrior.health, "Warrior's health should decrease by Archer's agility");
    }

    @Test
    @DisplayName("Take Damage: should reduce health and log appropriately")
    void takeDamage_shouldReduceHealth() {
        Archer archer = new Archer("Robin");
        int initialHealth = archer.health;

        archer.takeDamage(20);

        assertEquals(initialHealth - 20, archer.health, "Archer's health should be reduced by the damage taken");
    }

    @Test
    @DisplayName("Is Dead: should return true when health is 0 or below")
    void isDead_shouldReturnTrueWhenHealthIsZeroOrBelow() {
        Warrior warrior = new Warrior("Spartacus");

        warrior.takeDamage(100);
        assertTrue(warrior.isDead(), "Character should be dead when health is 0");

        warrior.takeDamage(10);
        assertTrue(warrior.isDead(), "Character should be dead when health is below 0");
    }

    @Test
    @DisplayName("Null or Empty Name: should assign 'Homeless' as default")
    void constructor_shouldAssignDefaultNameForNullOrEmpty() {
        Archer unnamedArcher = new Archer(null);
        Archer emptyNameArcher = new Archer("");

        assertAll("Default name assignment",
                () -> assertEquals("Homeless", unnamedArcher.name, "Name should default to 'Homeless'"),
                () -> assertEquals("Homeless", emptyNameArcher.name, "Name should default to 'Homeless'")
        );
    }
}