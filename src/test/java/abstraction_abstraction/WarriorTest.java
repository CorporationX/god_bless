package abstraction_abstraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {
    @Test
    void attack() {
        Character mage = new Warrior("Gandalf");
        Character archer = new Archer("Legolas");
        mage.attack(archer);
        assertEquals(90, archer.getHealth());
    }
}