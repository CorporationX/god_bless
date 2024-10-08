package school.faang.abstraction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherTest {

    @Test
    void attackTest() {

        TestInitData initData = new TestInitData();
        initData.generateData();

        initData.archer.attack(initData.warrior);

        assertEquals(initData.archer, initData.archerStandard);
        assertEquals(initData.warrior.getPower(), initData.warriorStandard.getPower());
        assertEquals(initData.warrior.getAgility(), initData.warriorStandard.getAgility());
        assertEquals(initData.warrior.getHealth(), initData.warriorStandard.getHealth() -
                initData.archer.getAgility());
    }
}