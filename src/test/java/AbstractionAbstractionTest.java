import abstractionAbstraction.Archer;
import abstractionAbstraction.Warrior;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbstractionAbstractionTest {
    private static final String WARRIOR_NAME = "TestWarrior";
    private static final String ARCHER_NAME = "TestArcher";

    private Warrior warrior;
    private Archer archer;

    @BeforeEach
    void setup() {
        warrior = new Warrior(WARRIOR_NAME);
        archer = new Archer(ARCHER_NAME);
    }

    @Test
    void testStatsOfCreatedCharacters() {
        assertEquals(WARRIOR_NAME, warrior.getName());
        assertEquals(Warrior.WARRIOR_STRENGTH, warrior.getStrength());
        assertEquals(Warrior.WARRIOR_AGILITY, warrior.getAgility());
        assertEquals(Warrior.WARRIOR_INTELLIGENCE, warrior.getIntelligence());
        assertEquals(ARCHER_NAME, archer.getName());
        assertEquals(Archer.ARCHER_STRENGTH, archer.getStrength());
        assertEquals(Archer.ARCHER_AGILITY, archer.getAgility());
        assertEquals(Archer.ARCHER_INTELLIGENCE, archer.getIntelligence());
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
