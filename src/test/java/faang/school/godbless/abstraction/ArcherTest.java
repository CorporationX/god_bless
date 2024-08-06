package faang.school.godbless.abstraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherTest {

    @Test
    void attack() {
        Archer archer = new Archer("a");
        Warrior warrior = new Warrior("w");
        archer.attack(warrior);
        assertEquals(90, warrior.health);
        assertEquals(100, archer.health);
    }
}