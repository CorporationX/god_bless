package faang.school.godbless.gameHeroesOfMightTest;

import faang.school.godbless.gameHeroesOfMight.Angel;
import faang.school.godbless.gameHeroesOfMight.Battlefield;
import faang.school.godbless.gameHeroesOfMight.Griffin;
import faang.school.godbless.gameHeroesOfMight.Hero;
import faang.school.godbless.gameHeroesOfMight.Pikeman;
import faang.school.godbless.gameHeroesOfMight.Swordman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class gameHeroesOfMightTest {

    private Hero hero1;
    private Hero hero2;

    @BeforeEach
    public void setUp() {
        hero1 = new Hero();
        hero1.setName("Hero1");
        hero1.setFraction("Faction1");

        hero2 = new Hero();
        hero2.setName("Hero2");
        hero2.setFraction("Faction2");

        // Add some creatures
        hero1.addCreature(new Pikeman("Pikeman1"), 10);
        hero1.addCreature(new Swordman("Swordman1"), 5);

        hero2.addCreature(new Angel("Angel1"), 3);
        hero2.addCreature(new Griffin("Griffin1"), 2);
    }

    @Test
    public void testAddCreature() {
        Pikeman pikeman2 = new Pikeman("Pikeman2");
        hero1.addCreature(pikeman2, 7);

        assertTrue(hero1.getOwnArmy().contains(pikeman2));
        assertEquals(7, pikeman2.getAmount());
    }

    @Test
    public void testRemoveCreature() {
        Swordman swordman = new Swordman("Swordman1");
        hero1.addCreature(swordman, 7);
        hero1.removeCreature(swordman, 3);
        assertEquals(4, swordman.getAmount());
        hero1.removeCreature(swordman, 4); // This should remove the Swordman from the army
        assertFalse(hero1.getOwnArmy().contains(swordman));
    }


    @Test
    public void testBattle() {
        Battlefield battlefield = new Battlefield();
        Hero winner = battlefield.battle(hero1, hero2);

        if (hero1.totalArmyDamage() > hero2.totalArmyDamage()) {
            assertEquals(hero1, winner);
        } else if (hero2.totalArmyDamage() > hero1.totalArmyDamage()) {
            assertEquals(hero2, winner);
        } else {
            assertNull(winner); // It's a tie
        }
    }
}





