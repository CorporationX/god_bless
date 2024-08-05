package faang.school.godbless.characterArcherWarriorAbstractClassTest;

import faang.school.godbless.characterArcherWarriorAbstractClass.Archer;
import faang.school.godbless.characterArcherWarriorAbstractClass.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CharacterTest{

    private Warrior warrior;
    private Archer archer;
    @BeforeEach
    public void setUp(){
        warrior = new Warrior("Conan");
        archer = new Archer("Legolas");
    }

    @Test
    public void testWarriorAttributes() {
        assertEquals("Conan", warrior.getName());
        assertEquals(10, warrior.getForce());
        assertEquals(5, warrior.getDexterity());
        assertEquals(3, warrior.getIntelligence());
        assertEquals(100, warrior.getHealth());
    }

    @Test
    public void testArcherAttributes() {
        assertEquals("Legolas", archer.getName());
        assertEquals(3, archer.getForce());
        assertEquals(10, archer.getDexterity());
        assertEquals(5, archer.getIntelligence());
        assertEquals(100, archer.getHealth());
    }
    @Test
    public void testAcrherAttack(){
        archer.attack(warrior);
        assertEquals(90, warrior.getHealth());
    }

    @Test
    public void testWarriorAttack(){
        warrior.attack(archer);
        assertEquals(90, archer.getHealth());
    }

    @Test
    public void testNegativeAttributes(){
         Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new TestCharacter("Test", -1, 5, 3) {};
        });
         assertEquals("Attributes cannot be negative", exception.getMessage());
    }
    @Test
    public void testInvalidName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Warrior("");
        });
        assertEquals("Name cannot be null or empty", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Archer(null);
        });
        assertEquals("Name cannot be null or empty", exception.getMessage());
    }
    @Test
    public void testAttackNullOpponent() {
        Warrior warrior = new Warrior("Conan");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            warrior.attack(null);
        });
        assertEquals("Opponent cannot be null", exception.getMessage());
    }

}
