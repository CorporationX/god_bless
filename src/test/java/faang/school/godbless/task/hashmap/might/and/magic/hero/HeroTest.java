package faang.school.godbless.task.hashmap.might.and.magic.hero;

import faang.school.godbless.task.hashmap.might.and.magic.creature.Angel;
import faang.school.godbless.task.hashmap.might.and.magic.creature.Creature;
import faang.school.godbless.task.hashmap.might.and.magic.hero.Hero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeroTest {
    private Hero hero;
    private final Creature angel = new Angel("Angel", 4);

    @BeforeEach
    void setUp() {
        hero = new Hero("Ahiles", "Troya", 347, 6, new HashMap<>());
    }

    @Test
    void testAddCreatureAndGetArmy() {
        hero.addCreature(angel, 3);
        assertTrue(hero.getArmy().contains(angel));
    }

    @Test
    void testRemoveCreature() {
        hero.addCreature(angel, 3);
        hero.removeCreature(angel, 3);
        var army = hero.getArmy();
        assertFalse(army.contains(angel));
    }
}
