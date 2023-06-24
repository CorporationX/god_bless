package sprint3.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sprint3.lambda.game.Archer;
import sprint3.lambda.game.Character;
import sprint3.lambda.game.Warrior;

import java.util.Random;

public class CharactersTest {
    private final Random RANDOM = new Random();
    private Character attacker;
    private final Character entity = new Warrior("Bob");

    @Test
    public void shouldOneCharacterSurvive() {
        Character entityRed = new Warrior("Gas");
        Character entityBlue = new Archer("Robin");
        simulateBattle(entityRed, entityBlue);

        Assertions.assertNotEquals(entityRed.getHealth(), entityBlue.getHealth());

        int survivorHealth = entityRed.getHealth() == 0 ? entityBlue.getHealth() : entityRed.getHealth();
        Assertions.assertNotEquals(0, survivorHealth);
    }

    @Test
    public void shouldAttackAtExpenseOfDexterity() {
        attacker = new Archer("Robin");
        int damageReceived = entity.getHealth();
        attacker.attack(entity);
        damageReceived -= entity.getHealth();

        Assertions.assertEquals(attacker.getDexterity(), damageReceived);
    }

    @Test
    public void shouldAttackAtExpenseOfStrength() {
        attacker = new Warrior("Gas");
        int damageReceived = entity.getHealth();
        attacker.attack(entity);
        damageReceived -= entity.getHealth();

        Assertions.assertEquals(attacker.getStrength(), damageReceived);
    }

    private void simulateBattle(Character entityRed, Character entityBlue) {
        while (!entityRed.isDead() && !entityBlue.isDead()) {
            if (RANDOM.nextBoolean()) {
                entityRed.attack(entityBlue);
            } else {
                entityBlue.attack(entityRed);
            }
        }
    }
}
