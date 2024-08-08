package faang.school.godbless.javahashmap.herouse;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    private static final Creature PIKEMAN = new Pikeman();
    private static final Creature GRIFFIN = new Griffin();
    private static final Creature ANGEL = new Angel();

    @Test
    void testAddCreature_OneCreature() {
        Hero hero = new Hero("Hero", "Human", 0, 1);

        hero.addCreature(PIKEMAN, 10);
        hero.addCreature(PIKEMAN, 10);

        Map<Creature, Integer> army = hero.getArmy();
        assertEquals(1, army.size());
        assertEquals(20, army.get(PIKEMAN));
    }

    @Test
    void testAddCreature_ManyCreature() {
        Hero hero = new Hero("Hero", "Human", 0, 1);

        hero.addCreature(PIKEMAN, 10);
        hero.addCreature(GRIFFIN, 25);
        hero.addCreature(ANGEL, 3);
        hero.addCreature(GRIFFIN, 5);
        hero.addCreature(ANGEL, 1);

        Map<Creature, Integer> army = hero.getArmy();
        assertEquals(3, army.size());
        assertEquals(10, army.get(PIKEMAN));
        assertEquals(30, army.get(GRIFFIN));
        assertEquals(4, army.get(ANGEL));
    }

    @Test
    void testRemoveCreature() {
        Hero hero = new Hero("Hero", "Human", 0, 1);
        hero.addCreature(PIKEMAN, 10);
        hero.addCreature(GRIFFIN, 25);
        hero.addCreature(ANGEL, 5);

        hero.removeCreature(GRIFFIN, 5);
        hero.removeCreature(ANGEL, 2);
        hero.removeCreature(GRIFFIN, 5);
        hero.removeCreature(PIKEMAN, 10);

        Map<Creature, Integer> army = hero.getArmy();
        assertEquals(2, army.size());
        assertEquals(15, army.get(GRIFFIN));
        assertEquals(3, army.get(ANGEL));
        assertNull(army.get(PIKEMAN));
    }
}