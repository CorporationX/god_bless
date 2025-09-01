package school.faang.abstraction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CharacterTest {

    @Test
    void testAttackCharacter() {
        Character warrior = new Warrior("Лотар");
        Character archer = new Archer("Леголас");

        for (int i = 0; i < 10; i++) {
            int hitPoints = archer.hitPoints;
            warrior.attack(archer);
            Assertions.assertEquals(archer.hitPoints, hitPoints - warrior.strength);
        }

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> warrior.attack(archer));
        Assertions.assertEquals(exception.getMessage(), "character " + archer.name + " cannot have hp below zero");
    }

}