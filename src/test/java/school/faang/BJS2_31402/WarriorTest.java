package school.faang.BJS2_31402;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WarriorTest {

    @Test
    void attackTest() {
        TestInitData initData = new TestInitData();
        initData.generateData();

        initData.warrior.attack(initData.archer);

        assertEquals(initData.warrior, initData.warriorStandard);
        assertEquals(initData.archer.getPower(), initData.archerStandard.getPower());
        assertEquals(initData.archer.getAgility(), initData.archerStandard.getAgility());
        assertEquals(initData.archer.getHealth(), initData.archerStandard.getHealth() -
                initData.warrior.getPower());
    }
}