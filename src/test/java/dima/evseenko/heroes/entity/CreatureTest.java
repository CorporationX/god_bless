package dima.evseenko.heroes.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreatureTest {

    @Test
    void takeDamage() {
        Creature creature1 = new Pikeman("Pikeman 1");
        creature1.takeDamage(10);

        assertEquals(100 - (10 - creature1.getProtection()), creature1.getHp());
    }

    @Test
    void attack() {
        Creature creature1 = new Pikeman("Pikeman 1");
        Creature creature2 = new Pikeman("Pikeman 2");

        creature1.attack(creature2);

        assertEquals(100 - (creature1.getDamage() - creature2.getProtection()), creature2.getHp());
    }
}