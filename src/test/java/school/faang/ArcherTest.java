package school.faang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherTest {

    @Test
    void attackTest() {
        TestInitData.generateData();

        TestInitData.archer.attack(TestInitData.warrior);

        assertEquals(TestInitData.archer, TestInitData.archerStandard);
        assertEquals(TestInitData.warrior.getPower(), TestInitData.warriorStandard.getPower());
        assertEquals(TestInitData.warrior.getAgility(), TestInitData.warriorStandard.getAgility());
        assertEquals(TestInitData.warrior.getHealth(), TestInitData.warriorStandard.getHealth() -
                                                        TestInitData.archer.getAgility());
    }
}