package school.faang.task_43950;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    @DisplayName("Fight Simulation: one character should die after fight")
    void fightSimulation_oneCharacterShouldDie() {
        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");

        Main.startFight(warrior, archer);

        assertTrue(warrior.isDead() || archer.isDead(), "One character should die after the fight");
    }

    @Test
    @DisplayName("Bleeding Effect: should apply damage to both characters")
    void applyBleedingEffect_shouldReduceHealthOfBothCharacters() {
        Character attacker = new Archer("Legolas");
        Character defender = new Warrior("Conan");

        attacker.health = 50;
        defender.health = 50;

        int mockAttackerBleeding = 3;
        attacker.takeDamage(mockAttackerBleeding);

        int mockDefenderBleeding = 5;
        defender.takeDamage(mockDefenderBleeding);

        assertAll("Bleeding effect",
                () -> assertEquals(47, attacker.health, "Attacker's health should decrease by mock value"),
                () -> assertEquals(45, defender.health, "Defender's health should decrease by mock value")
        );
    }
}