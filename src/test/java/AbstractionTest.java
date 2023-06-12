import faang.school.godbless.Archer;
import faang.school.godbless.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AbstractionTest {


    @Test
    void attack() {
        final Warrior warrior = new Warrior("Warrior");
        final Archer archer = new Archer("Archer");

        archer.attack(warrior);
        warrior.attack(archer);

        assertEquals(warrior.getHealth(), 90);
        assertEquals(archer.getHealth(), 90);
    }


}
