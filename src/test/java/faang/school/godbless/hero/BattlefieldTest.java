package faang.school.godbless.hero;

import faang.school.godbless.creation.Angel;
import faang.school.godbless.creation.Swordman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattlefieldTest {
    private Battlefield battlefield;

    @Test
    void testFight_FightArmyPositive() {
        var attackHero = new Hero("attack", "f1", 1, 1);
        var defenderHero = new Hero("defender", "f1", 1, 1);
        attackHero.addCreature(new Swordman("sword", 1), 10);
        defenderHero.addCreature(new Angel("angel", 1), 100);
        battlefield = new Battlefield(attackHero, defenderHero);

        var resultHero = battlefield.fight();
        var expected = defenderHero;

        assertEquals(expected, resultHero);
    }

    @Test
    void testFight_attackArmyIsEmptyPositive() {
        var attackHero = new Hero("attack", "f1", 1, 1);
        var defenderHero = new Hero("defender", "f1", 1, 1);
        defenderHero.addCreature(new Angel("angel", 1), 100);
        battlefield = new Battlefield(attackHero, defenderHero);

        var resultHero = battlefield.fight();
        var expected = defenderHero;

        assertEquals(expected, resultHero);
    }

    @Test
    void testFight_defenderArmyIsEmptyPositive() {
        var attackHero = new Hero("attack", "f1", 1, 1);
        var defenderHero = new Hero("defender", "f1", 1, 1);
        attackHero.addCreature(new Swordman("sword", 1), 10);
        battlefield = new Battlefield(attackHero, defenderHero);

        var resultHero = battlefield.fight();
        var expected = attackHero;

        assertEquals(expected, resultHero);
    }

    @Test
    void testFight_OneHeroNullNegative() {
        Hero attackHero = null;
        var defenderHero = new Hero("defender", "f1", 1, 1);
        assertThrows(IllegalArgumentException.class, () -> battlefield = new Battlefield(attackHero, defenderHero));
    }

    @Test
    void testFight_BothArmyIsEmptyNegative() {
        var attackHero = new Hero("attack", "f1", 1, 1);
        var defenderHero = new Hero("defender", "f1", 1, 1);
        assertThrows(IllegalArgumentException.class, () -> battlefield = new Battlefield(attackHero, defenderHero));
    }
}