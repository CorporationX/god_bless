package dima.evseenko.abstraction.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WarriorTest {

    @Test
    void attack() {
        Character warrior = new Warrior("Dima");
        Character archer = new Archer("Kolya");

        warrior.attack(archer);

        assertEquals(100 - warrior.getStrength(), archer.getHealth());
    }
}