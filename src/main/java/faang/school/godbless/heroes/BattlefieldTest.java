package faang.school.godbless.heroes;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BattlefieldTest {
    @Test
    void drawResult() {
        Hero hero1 = new Hero("Hero 1");
        Hero hero2 = new Hero("Hero 2");

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Optional<Hero> winner = battlefield.battle();

        assertTrue(winner.isEmpty());
    }

    @Test
    void hero1Wins() {
        Hero hero1 = new Hero("Hero 1");
        Hero hero2 = new Hero("Hero 2");

        hero1.addCreature(new Angel(5));
        hero1.addCreature(new Griffin(3));
        hero1.addCreature(new Pikeman(3));

        hero2.addCreature(new Pikeman(4));
        hero2.addCreature(new Swordman(4));

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Optional<Hero> winner = battlefield.battle();

        assertEquals(winner.get(), hero1);
    }

    @Test
    void hero2Wins() {
        Hero hero1 = new Hero("Hero 1");
        Hero hero2 = new Hero("Hero 2");

        hero1.addCreature(new Pikeman(4));
        hero1.addCreature(new Swordman(4));

        hero2.addCreature(new Angel(5));
        hero2.addCreature(new Griffin(3));
        hero2.addCreature(new Swordman(5));

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Optional<Hero> winner = battlefield.battle();

        assertEquals(winner.get(), hero2);
    }
}