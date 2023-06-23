package abstraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharactersTest {
    private Warrior warrior;
    private Archer archer;

    @BeforeEach
    public void setUp(){
        warrior = new Warrior("Kraken");
        archer = new Archer("Dragon");
    }
    @Test
    public void attackWarrior_shouldReturnCorrectHealth(){
        warrior.attack(archer);
        archer.attack(warrior);
        assertEquals(90, archer.getHealth());
        assertEquals(90, warrior.getHealth());
    }
}
