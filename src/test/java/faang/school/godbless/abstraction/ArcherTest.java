package faang.school.godbless.abstraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherTest {
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
        name = "Archer";
        health = 100;
        force = 3;
        dexterity = 10;
        intelligence = 5;
        residualHealth = health - dexterity;

        warrior = new Warrior("Warrior");
        archer = new Archer(name);
    }

    @Test
    void testCreateArcher() {
        assertDoesNotThrow(() -> new Archer(name));
        assertEquals(name, archer.name);
        assertEquals(force, archer.force);
        assertEquals(dexterity, archer.dexterity);
        assertEquals(intelligence, archer.intelligence);
        assertEquals(health, archer.health);
    }


    @Test
    void testAttack() {
        archer.attack(warrior);
        assertEquals(residualHealth, warrior.health);
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            for (int i = 0; i < 15; i++) archer.attack(warrior);
        });
    }

    @Test
    void shouldThrowException(){
        assertThrowsExactly(IllegalArgumentException.class, () -> new Archer(""));
        assertThrowsExactly(IllegalArgumentException.class, () -> new Archer(" "));
    }
}