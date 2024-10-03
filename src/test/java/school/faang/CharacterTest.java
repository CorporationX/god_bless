package school.faang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    private Archer archer;
    private Warrior warrior;

    @BeforeEach
    public void setUp() {
        archer = new Archer("Archer");
        warrior = new Warrior("Warrior");
    }

    @Test
    public void shouldReduceHealthWhenWarriorAttack() {
        int archerHealth = archer.getHealth();
        warrior.attack(archer);
        assertEquals(archerHealth - warrior.getStrength(), archer.getHealth());
    }

    @Test
    public void shouldReduceHealthWhenArcherAttack() {
        int warriorHealth = warrior.getHealth();
        archer.attack(warrior);
        assertEquals(warriorHealth - archer.getAgility(), warrior.getHealth());
    }
}
