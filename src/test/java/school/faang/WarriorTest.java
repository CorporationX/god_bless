package school.faang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    @Test
    void attackTest() {
        TestInitData.generateData();

        TestInitData.warrior.attack(TestInitData.archer);

        assertEquals(TestInitData.warrior, TestInitData.warriorStandard);
        assertEquals(TestInitData.archer.getPower(), TestInitData.archerStandard.getPower());
        assertEquals(TestInitData.archer.getAgility(), TestInitData.archerStandard.getAgility());
        assertEquals(TestInitData.archer.getHealth(), TestInitData.archerStandard.getHealth() -
                TestInitData.warrior.getPower());
    }
}