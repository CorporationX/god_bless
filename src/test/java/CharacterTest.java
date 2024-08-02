import faang.school.godbless.BJS2_18493.Archer;
import faang.school.godbless.BJS2_18493.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {
    @Test
    public void testWarriorInitialization() {
        Warrior warrior = new Warrior("Warrior1");
        assertEquals("Warrior1", warrior.getName());
        assertEquals(10, warrior.getPower());
        assertEquals(5, warrior.getAgility());
        assertEquals(3, warrior.getIntelligence());
        assertEquals(100, warrior.getHealth());
    }

    @Test
    public void testArcherInitialization() {
        Archer archer = new Archer("Archer1");
        assertEquals("Archer1", archer.getName());
        assertEquals(3, archer.getPower());
        assertEquals(10, archer.getAgility());
        assertEquals(5, archer.getIntelligence());
        assertEquals(100, archer.getHealth());
    }

    @Test
    public void testWarriorAttack() {
        Warrior warrior = new Warrior("Warrior1");
        Archer archer = new Archer("Archer1");
        warrior.attack(archer);
        assertEquals(90, archer.getHealth());
    }

    @Test
    public void testArcherAttack() {
        Warrior warrior = new Warrior("Warrior1");
        Archer archer = new Archer("Archer1");
        archer.attack(warrior);
        assertEquals(97, warrior.getHealth());
    }
}
