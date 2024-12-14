package school.faang.task_43950;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WarriorTest {

    @Test
    @DisplayName("Constructor: should initialize default stats")
    void constructor_shouldInitializeDefaultStats() {
        Warrior warrior = new Warrior("Conan");

        assertAll("Default stats for Warrior",
                () -> assertEquals(10, warrior.getStrength(), "Strength should be 10"),
                () -> assertEquals(1, warrior.getAgility(), "Agility should be 1"),
                () -> assertEquals(3, warrior.getIntelligence(), "Intelligence should be 3")
        );
    }

    @Test
    @DisplayName("Attack: should deal damage based on strength")
    void attack_shouldDealDamageBasedOnStrength() {
        Warrior warrior = new Warrior("Conan");
        Archer target = new Archer("Legolas");

        int targetInitialHealth = target.getHealth();
        warrior.attack(target);

        assertEquals(targetInitialHealth - warrior.getStrength(), target.getHealth(),
                "Damage should match Warrior's strength");
    }
}