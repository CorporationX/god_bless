package abstraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbstractionTest {
    private static final String WARRIOR_NAME = "TestWarrior";
    private static final String ARCHER_NAME = "TestArcher";

    private Character warrior;
    private Character archer;

    @BeforeEach
    void setup() {
        warrior = new Warrior(WARRIOR_NAME);
        archer = new Archer(ARCHER_NAME);
    }

    @Test
    void testStatsOfCreatedCharacters() {
        assertEquals(WARRIOR_NAME, warrior.getName());
        assertEquals(Warrior.warriorStrength, warrior.getStrength());
        assertEquals(Warrior.warriorAgility, warrior.getAgility());
        assertEquals(Warrior.warriorIntelligence, warrior.getIntelligence());
        assertEquals(ARCHER_NAME, archer.getName());
        assertEquals(Archer.archerStrength, archer.getStrength());
        assertEquals(Archer.archerAgility, archer.getAgility());
        assertEquals(Archer.archerIntelligence, archer.getIntelligence());
    }

    @Test
    void testAttack() {
        warrior.attack(archer);
        warrior.attack(archer);
        archer.attack(warrior);

        assertEquals(80, archer.getHealth());
        assertEquals(90, warrior.getHealth());
    }
}
