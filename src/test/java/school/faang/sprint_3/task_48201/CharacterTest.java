package school.faang.sprint_3.task_48201;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    void testArcherPower() {
        Archer archer = new Archer(25);
        assertEquals(25, archer.getPower());
    }

    @Test
    void testSwordsmanPower() {
        Swordsman swordsman = new Swordsman(40);
        assertEquals(40, swordsman.getPower());
    }

    @Test
    void testMagePower() {
        Mage mage = new Mage(50);
        assertEquals(50, mage.getPower());
    }
}
