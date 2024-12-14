package faang.school.godbless.dolbahlop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BattlefieldTest {
    private Hero hero1;
    private Hero hero2;
    private Battlefield battlefield;

    @BeforeEach
    void setUp() {
        hero1 = new Hero("Sir Roland", "Castle");
        hero2 = new Hero("Dark Knight", "Inferno");
        battlefield = new Battlefield(hero1, hero2);

        // Настраиваем армии для теста
        Creature pikeman = new Pikeman(10);
        Creature griffin = new Griffin(5);
        Creature demon = new Swordman(8);
        Creature dragon = new Angel(3);

        hero1.addCreature(pikeman, 10);
        hero1.addCreature(griffin, 5);
        hero2.addCreature(demon, 8);
        hero2.addCreature(dragon, 3);
    }

    @Test
    void shouldDetermineBattleWinnerCorrectly() {
        // Arrange
        int hero1Strength = hero1.calculateTotalDamage();
        int hero2Strength = hero2.calculateTotalDamage();

        // Act
        Hero winner = battlefield.battle();

        // Assert
        if (hero1Strength >= hero2Strength) {
            assertEquals(hero1, winner);
        } else {
            assertEquals(hero2, winner);
        }
    }
}
