package faang.school.godbless.characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WarriorTest {

    @Test
    void testCreation() {
        var warrior = new Warrior("name");

        Assertions.assertAll(
                ()-> Assertions.assertEquals("name", warrior.getName()),
                ()-> Assertions.assertEquals(100, warrior.getHealth()),
                ()-> Assertions.assertEquals(10, warrior.getForce()),
                ()-> Assertions.assertEquals(5, warrior.getAgility()),
                ()-> Assertions.assertEquals(3, warrior.getIntelligence())
        );
    }

    @Test
    void testAttack() {
        var warrior = new Warrior("name");

        Character character = new Warrior("warrior");

        Assertions.assertEquals(100, character.getHealth());
        Assertions.assertEquals(100, warrior.getHealth());
        warrior.attack(character);

        Assertions.assertAll(
                () -> Assertions.assertEquals(100, warrior.getHealth()),
                () -> Assertions.assertEquals(90, character.getHealth())
        );
    }

    @Test
    void testTotalAttack() {
        var warrior = new Warrior("name");
        Character character = new Warrior("warrior");

        Assertions.assertEquals(100, character.getHealth());
        for (int i = 0; i < 10; i++) {
            warrior.attack(character);
        }
        Assertions.assertEquals(0, character.getHealth());

        warrior.attack(character);
        Assertions.assertEquals(0, character.getHealth());
    }

}
