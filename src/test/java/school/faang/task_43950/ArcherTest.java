package school.faang.task_43950;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArcherTest {

    @Test
    @DisplayName("Constructor: should initialize default stats")
    void constructor_shouldInitializeDefaultStats() {
        Archer archer = new Archer("Legolas");

        assertAll("Default stats for Archer",
                () -> assertEquals(3, archer.getStrength(), "Strength should be 3"),
                () -> assertEquals(10, archer.getAgility(), "Agility should be 10"),
                () -> assertEquals(5, archer.getIntelligence(), "Intelligence should be 5")
        );
    }

    @Test
    @DisplayName("Attack: should deal damage based on agility")
    void attack_shouldDealDamageBasedOnAgility() {
        Archer archer = new Archer("Legolas");
        Warrior target = new Warrior("Conan");

        int targetInitialHealth = target.getHealth();
        archer.attack(target);

        assertEquals(targetInitialHealth - archer.getAgility(), target.getHealth(),
                "Damage should match Archer's agility");
    }
}