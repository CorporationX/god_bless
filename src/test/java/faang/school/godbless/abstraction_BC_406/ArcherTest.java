package faang.school.godbless.abstraction_BC_406;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArcherTest {
    @Test
    public void testAttackCorrectly() {
        Archer archer = new Archer("Gabriel");
        Warrior warrior = new Warrior("Mikhael");
        int expected = 90;
        int actual = archer.attack(warrior);

        Assertions.assertEquals(expected, actual);
    }
}