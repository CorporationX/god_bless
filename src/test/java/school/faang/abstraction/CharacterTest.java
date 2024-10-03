package school.faang.abstraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {
    @Test
    public void testCreateArcher() {
        Character archer = new Archer("Archer");
        assertEquals("Archer", archer.name);
        assertEquals(3, archer.strength);
        assertEquals(10, archer.agility);
        assertEquals(5, archer.intelligence);
        assertEquals(100, archer.health);
    }

    @Test
    public void testCreateWarrior() {
        Character warrior = new Warrior("Warrior");
        assertEquals("Warrior", warrior.name);
        assertEquals(10, warrior.strength);
        assertEquals(5, warrior.agility);
        assertEquals(3, warrior.intelligence);
        assertEquals(100, warrior.health);
    }

    @Test
    public void testWarriorAttackWarrior(){
        Character warrior1 = new Warrior("Warrior1");
        Character warrior2 = new Warrior("Warrior2");

        warrior1.attack(warrior2);

        assertEquals(0, warrior2.strength);
        assertEquals(10, warrior1.strength);
    }

    @Test
    public void testWarriorAttackArcher(){
        Character warrior = new Warrior("Warrior");
        Character archer = new Archer("Archer");

        warrior.attack(archer);

        assertEquals(10, warrior.strength);
        assertEquals(-7, archer.strength);
    }

    @Test
    public void testArcherAttackArcher(){
        Character archer1 = new Archer("Archer1");
        Character archer2 = new Archer("Archer2");

        archer1.attack(archer2);

        assertEquals(0, archer2.agility);
        assertEquals(10, archer1.agility);
    }

    @Test
    public void testArcherAttackWarrior(){
        Character archer = new Archer("Archer");
        Character warrior = new Warrior("Warrior");

        archer.attack(warrior);

        assertEquals(-5, warrior.agility);
        assertEquals(10, archer.agility);
    }

}
