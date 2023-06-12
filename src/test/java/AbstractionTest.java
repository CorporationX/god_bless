import faang.school.godbless.Archer;
import faang.school.godbless.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AbstractionTest {
    final Warrior warrior = new Warrior("Warrior");
    final Archer archer = new Archer("Archer");

    @Test
    void attack() {
        archer.attack(warrior);
        assertEquals(warrior.getHealth(), 90);
        warrior.attack(archer);
        assertEquals(archer.getHealth(), 90);
    }


}
