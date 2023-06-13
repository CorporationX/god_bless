import faang.school.godbless.classes.Archer;
import faang.school.godbless.classes.Character;
import faang.school.godbless.classes.Warrior;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestCharacters {
    private static Character warrior;
    private static Character archer;

    @BeforeAll
    public static void setUp(){
        warrior = new Warrior("Rustam");
        archer = new Archer("Ruby");
    }
    //Positive
    @Test
    @DisplayName("Attack")
    public void attackTest(){
        warrior.attack(archer);
        Assertions.assertEquals(90, archer.getHealth());
        archer.attack(warrior);
        Assertions.assertEquals(90, warrior.getHealth());
    }

    @Test
    @DisplayName("AttackWithZeroHP")
    public void attackWithZeroHP(){
        Character character = new Archer("Someone");
        character.setHealth(1);
        warrior.attack(character);
        Assertions.assertEquals(-9, character.getHealth());
        character.setHealth(0);
        warrior.attack(character);
        Assertions.assertEquals(0, character.getHealth());
    }

}
