package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArcherTest {
    private Archer archer;
    private Character character;

    @BeforeEach
    public void Setup(){
        archer = new Archer("Archer");
        character = new Character("Character") {
            @Override
            public void attack(Character character) {

            }
        };
    }

    @Test
    public void testArcherAttack(){
        archer.attack(character);
        assertEquals(90, character.healthPoints);
    }
}
