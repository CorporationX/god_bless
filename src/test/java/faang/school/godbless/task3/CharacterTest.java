package faang.school.godbless.task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CharacterTest {
    private Character firstCharacter;
    private Character secondCharacter;
    @BeforeEach
    public void setUp() {
        firstCharacter = new Warrior("Warrior");
        secondCharacter = new Archer("Archer");
    }

    @Test
    public void testToAttackAliveCharacter() {
        int health = secondCharacter.getHealth();
        firstCharacter.attack(secondCharacter);
        Assertions.assertNotEquals(health, secondCharacter.getHealth());
    }

    @Test
    public void testToAttackDeadCharacter() {
        secondCharacter.setHealth(0);
        int health = secondCharacter.getHealth();
        firstCharacter.attack(secondCharacter);
        Assertions.assertEquals(health, secondCharacter.getHealth());
    }
}
