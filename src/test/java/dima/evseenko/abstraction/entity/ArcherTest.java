package dima.evseenko.abstraction.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArcherTest {

    @Test
    void attack() {
        Character warrior = new Warrior("Dima");
        Character archer = new Archer("Kolya");

        archer.attack(warrior);

        assertEquals(100 - archer.getIntelligence(), warrior.getHealth());
    }
}