package faang.school.godbless.dolbahlop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    private Hero hero;
    private Creature pikeman;
    private Creature griffin;

    @BeforeEach
    void setUp() {
        hero = new Hero("Sir Roland", "Castle");
        pikeman = new Pikeman(10);
        griffin = new Griffin(5);
    }

    @Test
    void shouldAddNewCreatureToArmy() {
        // Arrange
        int initialArmySize = hero.getArmy().size();

        // Act
        hero.addCreature(pikeman, 10);

        // Assert
        assertEquals(initialArmySize + 1, hero.getArmy().size());
        assertTrue(hero.getArmy().contains(pikeman));
        assertEquals(10, pikeman.getQuantity());
    }

    @Test
    void shouldRemoveCreatureCompletelyWhenQuantityIsZeroOrLess() {
        // Arrange
        hero.addCreature(pikeman, 10);

        // Act
        hero.removeCreature(pikeman, 10);

        // Assert
        assertFalse(hero.getArmy().contains(pikeman));
    }

    @Test
    void shouldReduceCreatureQuantity() {
        // Arrange
        hero.addCreature(pikeman, 10);

        // Act
        hero.removeCreature(pikeman, 5);

        // Assert
        assertTrue(hero.getArmy().contains(pikeman));
        assertEquals(5, pikeman.getQuantity());
    }

    @Test
    void shouldCalculateTotalDamageCorrectly() {
        // Arrange
        hero.addCreature(pikeman, 10);
        hero.addCreature(griffin, 5);
        int expectedDamage = pikeman.calculateDamage() + griffin.calculateDamage();

        // Act
        int totalDamage = hero.calculateTotalDamage();

        // Assert
        assertEquals(expectedDamage, totalDamage);
    }
}