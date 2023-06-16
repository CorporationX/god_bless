package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarriorTest {
    private Warrior warrior;
    private Archer archer;

    @BeforeEach
    public void setUp(){
        warrior = new Warrior("Warrior");
        archer = new Archer("Archer");
    }

    @Test
    public void testWarriorAttack(){
        warrior.attack(archer);
        assertEquals(90, archer.healthPoints);
    }
}
