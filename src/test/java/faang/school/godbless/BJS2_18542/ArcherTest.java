package faang.school.godbless.BJS2_18542;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherTest {

    @Test
    void attackTest() {
        Archer archer1 = new Archer("Archer1");
        Archer archer2 = new Archer("Archer2");

        archer1.attack(archer2);

        assertEquals(90, archer2.getHealth());
    }
}