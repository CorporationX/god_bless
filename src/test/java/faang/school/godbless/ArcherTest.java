package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArcherTest {
    private Archer archer;
    private Warrior warrior;

    @BeforeEach
    public void setUp(){
        archer = new Archer("Archer");
        warrior = new Warrior("Warrior");
    }

    @Test
    public void testArcherAttack(){
        archer.attack(warrior);
        assertEquals(90, warrior.healthPoints);
    }
}
