package faang.school.godbless.characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CharacterTest {
    @Test
    void testDecrease() {
        var character = createAbstractCharacter();

        Assertions.assertEquals(100, character.getHealth());
        character.decreaseHealth(10);
        Assertions.assertEquals(90, character.getHealth());
    }

    @Test
    void testTotalDecrease() {
        var character = createAbstractCharacter();

        Assertions.assertEquals(100, character.getHealth());
        character.decreaseHealth(101);
        Assertions.assertEquals(0, character.getHealth());
    }

    @Test
    void testZeroDecrease() {
        var character = createAbstractCharacter();

        Assertions.assertEquals(100, character.getHealth());
        character.decreaseHealth(0);
        Assertions.assertEquals(100, character.getHealth());
    }

    @Test
    void testNegativeDecrease() {
        var character = createAbstractCharacter();

        Assertions.assertEquals(100, character.getHealth());
        character.decreaseHealth(-10);
        Assertions.assertEquals(100, character.getHealth());
    }

    Character createAbstractCharacter() {
        return new Character("name") {
            @Override
            public void attack(Character character) {
            }
        };
    }

}
