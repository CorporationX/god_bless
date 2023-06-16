package faang.school.godbless.abstraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    private Warrior warrior;
    private Archer archer;
    private String name;
    private float health;
    private float force;
    private float dexterity;
    private float intelligence;
    private float residualHealth;

    @BeforeEach
    void setUp() {
        name = "Warrior";
        health = 100;
        force = 10;
        dexterity = 5;
        intelligence = 3;
        residualHealth = health - force;

        warrior = new Warrior(name);
        archer = new Archer("Archer");
    }

    @Test
    void testCreateWarrior() {
        assertDoesNotThrow(() -> new Warrior(name));
        assertEquals(name, warrior.name);
        assertEquals(force, warrior.force);
        assertEquals(dexterity, warrior.dexterity);
        assertEquals(intelligence, warrior.intelligence);
        assertEquals(health, warrior.health);
    }


    @Test
    void testAttack() {
        warrior.attack(archer);
        assertEquals(residualHealth, archer.health);
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            for (int i = 0; i < 15; i++) warrior.attack(archer);
        });
    }

    @Test
    void shouldThrowException(){
        assertThrowsExactly(IllegalArgumentException.class, () -> new Warrior(""));
        assertThrowsExactly(IllegalArgumentException.class, () -> new Warrior(" "));
    }
}