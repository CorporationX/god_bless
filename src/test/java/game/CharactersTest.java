package game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class CharactersTest {
    private final Random RANDOM = new Random();
    @Test
    public void shouldOneCharacterSurvive() {
        Character entityRed = new Warrior("Gas");
        Character entityBlue = new Archer("Robin");
        simulateBattle(entityRed, entityBlue);

        Assertions.assertNotEquals(entityRed.getHealth(), entityBlue.getHealth());

        int survivorHealth = entityRed.getHealth() == 0 ? entityBlue.getHealth() : entityRed.getHealth();
        Assertions.assertNotEquals(0, survivorHealth);
    }

    private void simulateBattle(Character entityRed, Character entityBlue) {
        while (entityRed.getHealth() != 0 || entityBlue.getHealth() != 0) {
            if (RANDOM.nextBoolean()) {
                entityRed.attack(entityBlue);
            } else {
                entityBlue.attack(entityRed);
            }
        }
    }
}
