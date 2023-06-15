package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarriorTest {
    private Warrior warrior;
    private Character character;

    @BeforeEach
    public void Setup(){
        warrior = new Warrior("Warrior");
        character = new Character("Character") {
            @Override
            public void attack(Character character) {

            }
        };
    }

    @Test
    public void testWarriorAttack(){
        warrior.attack(character);
        assertEquals(90, character.healthPoints);
    }
}
