package school.faang;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {
    private Character archer;
    private Character warrior;
    private Character target;

    @BeforeEach
    public void setUp() {
        archer = new Archer("ArcherOne");
        warrior = new Warrior("WarriorOne");
        target = new Warrior("TargetWarrior");  // A generic target to be attacked
    }

    @Test
    public void testArcherInitialization() {
        assertEquals(3, archer.getPower());
        assertEquals(10, archer.getAgility());
        assertEquals(5, archer.getIntellect());
        assertEquals(100, archer.getHealth());
    }

    @Test
    public void testWarriorInitialization() {
        assertEquals(10, warrior.getPower());
        assertEquals(5, warrior.getAgility());
        assertEquals(3, warrior.getIntellect());
        assertEquals(100, warrior.getHealth());
    }

    @Test
    public void testArcherAttack() {
        archer.attack(target);
        assertEquals(90, target.getHealth());
    }

    @Test
    public void testWarriorAttack() {
        warrior.attack(target);
        assertEquals(90, target.getHealth());
    }
}
