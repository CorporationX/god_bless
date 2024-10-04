package abstractionAbstraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArcherTest {

    private Archer archer;

    @BeforeEach
    void setUp(){
        archer = new Archer("Silvana");
    }

    @Test
    @DisplayName("Archer attack test")
    void attackTest() {
        Warrior warrior = new Warrior("Grommash");
        archer.attack(warrior);
        assertEquals(90, warrior.getHp());
    }
}
