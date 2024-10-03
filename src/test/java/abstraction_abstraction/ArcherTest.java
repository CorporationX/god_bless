package abstraction_abstraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherTest {
    @Test
    void attack() {
        Character mage = new Warrior("Gandalf");
        Character archer = new Archer("Legolas");
        archer.attack(mage);
        assertEquals(90, mage.getHealth());
    }
}