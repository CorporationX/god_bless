package faang.school.godbless.characters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArcherTest {

    @Test
    void testCreation() {
        var archer = new Archer("name");

        Assertions.assertAll(
                ()-> Assertions.assertEquals("name", archer.getName()),
                ()-> Assertions.assertEquals(100, archer.getHealth()),
                ()-> Assertions.assertEquals(3, archer.getForce()),
                ()-> Assertions.assertEquals(10, archer.getAgility()),
                ()-> Assertions.assertEquals(5, archer.getIntelligence())
        );
    }

    @Test
    void testAttack() {
        var archer = new Archer("name");

        Character character = new Warrior("warrior");

        Assertions.assertEquals(100, character.getHealth());
        Assertions.assertEquals(100, archer.getHealth());
        archer.attack(character);

        Assertions.assertAll(
                () -> Assertions.assertEquals(100, archer.getHealth()),
                () -> Assertions.assertEquals(90, character.getHealth())
        );
    }

    @Test
    void testTotalAttack() {
        var archer = new Archer("name");
        Character character = new Warrior("warrior");

        Assertions.assertEquals(100, character.getHealth());
        for (int i = 0; i < 10; i++) {
            archer.attack(character);
        }
        Assertions.assertEquals(0, character.getHealth());

        archer.attack(character);
        Assertions.assertEquals(0, character.getHealth());
    }

}
