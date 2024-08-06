package faang.school.godbless.BJS2_18542;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    @Test
    void attackTest() {
        Warrior Warrior1 = new Warrior("Warrior1");
        Warrior Warrior2 = new Warrior("Warrior2");

        Warrior1.attack(Warrior2);

        assertEquals(90, Warrior2.getHealth());
    }
}