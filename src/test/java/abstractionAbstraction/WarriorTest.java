package abstractionAbstraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarriorTest {

    private Warrior warrior;

    @BeforeEach
    void setUp(){
        warrior = new Warrior("Grommash");
    }

    @Test
    @DisplayName("Warrior attack test")
    void attackTest() {
        Archer archer = new Archer("Silvana");
        warrior.attack(archer);
        assertEquals(90, archer.getHp());
    }
}
