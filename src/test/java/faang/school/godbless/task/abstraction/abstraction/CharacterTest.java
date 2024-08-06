package faang.school.godbless.task.abstraction.abstraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {
    private Warrior warrior;
    private Archer archer;
    private int actualHealth;
    private int expectedHealth;

    @BeforeEach
    void setUp() {
        warrior = new Warrior("NameOfWarrior");
        archer = new Archer("NameOfArcher");
    }

    @Test
    void testWarriorAttackToArcher() {
        expectedHealth = archer.health - warrior.strength;
        warrior.attack(archer);
        actualHealth = archer.health;

        assertEquals(expectedHealth, actualHealth);
    }

    @Test
    void testWarriorAttackToNull() {
        warrior.attack(null);
    }

    @Test
    void testArcherAttackToWarrior() {
        expectedHealth = warrior.health - archer.dexterity;
        archer.attack(warrior);
        actualHealth = warrior.health;

        assertEquals(expectedHealth, actualHealth);
    }

    @Test
    void testArcherAttackToNull() {
        archer.attack(warrior);
    }
}
