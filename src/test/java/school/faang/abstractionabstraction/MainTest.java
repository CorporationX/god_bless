package school.faang.abstractionabstraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testDefaultStats() {
        Warrior war1 = new Warrior("war1");
        Archer arch1 = new Archer("arch1");

        assertEquals(war1.name, "war1");
        assertEquals(war1.strength, Warrior.DEFAULT_STRENGTH);
        assertEquals(war1.dexterity, Warrior.DEFAULT_DEXTERITY);
        assertEquals(war1.intelligence, Warrior.DEFAULT_INTELLIGENCE);
        assertEquals(war1.health, Warrior.DEFAULT_HEALTH);

        assertEquals(arch1.name, "arch1");
        assertEquals(arch1.strength, Archer.DEFAULT_STRENGTH);
        assertEquals(arch1.dexterity, Archer.DEFAULT_DEXTERITY);
        assertEquals(arch1.intelligence, Archer.DEFAULT_INTELLIGENCE);
        assertEquals(arch1.health, Archer.DEFAULT_HEALTH);
    }

    @Test
    public void testAttack() {
        Warrior war1 = new Warrior("war1");
        Archer arch1 = new Archer("arch1");

        war1.attack(arch1);
        assertEquals(arch1.health, Archer.DEFAULT_HEALTH - war1.strength);

        arch1.attack(war1);
        assertEquals(war1.health, Warrior.DEFAULT_HEALTH - arch1.dexterity);
    }
}
