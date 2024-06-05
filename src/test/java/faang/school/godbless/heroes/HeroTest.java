package faang.school.godbless.heroes;

import faang.school.godbless.Hero;
import faang.school.godbless.creation.Angel;
import faang.school.godbless.creation.Creature;
import faang.school.godbless.creation.Griffin;
import faang.school.godbless.creation.Pikeman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class HeroTest {
    private Hero hero;

    @BeforeEach
    void setUp() {
        hero = new Hero("hero", "fraction", 1, 1);
    }

    @Test
    void testAddCreature_SumTwoArmPositive() {
        Creature angel = new Angel("angel", 2);
        Map<Creature, Integer> expected = new HashMap<>();
        expected.put(angel, 100);
        hero.addCreature(angel, 50);
        assertEquals(expected, hero.addCreature(angel, 50));
    }

    @Test
    void testAddCreature_AddOneArmPositive() {
        Creature angel = new Angel("angel", 2);
        Map<Creature, Integer> expected = new HashMap<>();
        expected.put(angel, 50);
        assertEquals(expected, hero.addCreature(angel, 50));
    }

    @Test
    void testRemoveCreature_Positive() {
        Creature griffin = new Griffin("griffin", 3);
        Map<Creature, Integer> expected = new HashMap<>();
        expected.put(griffin, 0);
        hero.addCreature(griffin, 50);
        assertEquals(expected, hero.removeCreature(griffin, 50));
    }

    @Test
    void testAddCreature_AddZeroQuantityNegative() {
        Creature pikeman = new Pikeman("pikeman", 2);
        assertThrows(IllegalArgumentException.class, () -> hero.addCreature(pikeman, 0));
    }

    @Test
    void testAddCreature_AddNullCreatureNegative() {
        Creature pikeman = null;
        assertThrows(IllegalArgumentException.class, () -> hero.addCreature(pikeman, 10));
    }

    @Test
    void testRemoveCreature_RemoveZeroQuantityNegative() {
        Creature pikeman = new Pikeman("pikeman", 2);
        assertThrows(IllegalArgumentException.class, () -> hero.removeCreature(pikeman, 0));
    }

    @Test
    void testRemoveCreature_RemoveNullCreatureNegative() {
        Creature pikeman = null;
        assertThrows(IllegalArgumentException.class, () -> hero.removeCreature(pikeman, 10));
    }
}