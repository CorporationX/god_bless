package Task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestWarrior {
    private Warrior warrior;
    private final Character target = new Warrior("target");

    @BeforeEach
    public void setUp() {
        this.warrior = new Warrior("Warrior");
    }

    @Test
    void testOtherWarriorAttack() {
        warrior.attack(target);

        assertEquals(90, target.getHealth());
    }

    @Test
    void testArcherAttack() {
        Character target = new Archer("target");
        warrior.attack(target);

        assertEquals(90, target.getHealth());
    }

    @Test
    void testTargetDeath() {
        while (target.getHealth() > 0) {
            warrior.attack(target);
        }
        assertEquals(0, target.getHealth());
    }
}