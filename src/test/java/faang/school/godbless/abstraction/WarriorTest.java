package faang.school.godbless.abstraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    @Test
    void attack() {
        Archer archer = new Archer("a");
        Warrior warrior = new Warrior("w");
        warrior.attack(archer);
        assertEquals(90, archer.health);
        assertEquals(100, warrior.health);
    }
}