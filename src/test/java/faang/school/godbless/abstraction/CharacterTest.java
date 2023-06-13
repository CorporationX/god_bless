package faang.school.godbless.abstraction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {

    private Character character1;
    private Character character2;

    @BeforeEach
    void setUp(){
        character1 = new Warrior("Warrior");
        character2 = new Archer("Archer");
    }

    @Test
    void archerAttackTest(){
        String expected =  String.format(Message.DAMAGE_DONE, 10, 90) ;
        String actual = character2.attack(character1);

        assertEquals(expected, actual);
    }

    @Test
    void warriorAttackTest(){
        String expected =  String.format(Message.DAMAGE_DONE, 5, 95);
        String actual = character1.attack(character2);

        assertEquals(expected, actual);
    }

    @Test
    void warriorDies(){
        character1.setHealth(5);

        String expected = String.format(Message.ENEMY_DEAD, 10);
        String actual = character2.attack(character1);
    }

}
