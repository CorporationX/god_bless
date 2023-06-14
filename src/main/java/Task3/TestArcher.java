package Task3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestArcher {
    private final Archer archer = new Archer("Archer");
    private final Character target = new Warrior("target");

    @Test
    void testOtherArcherAttack() {
        Character target = new Archer("target");
        archer.attack(target);

        assertEquals(90, target.getHealth());
    }

    @Test
    void testWarriorAttack() {
        archer.attack(target);

        assertEquals(90, target.getHealth());
    }

    @Test
    void testTargetDeath() {
        while (target.getHealth() > 0) {
            archer.attack(target);
        }
        assertEquals(0, target.getHealth());
    }
}