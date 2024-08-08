import faang.school.godbless.BJS218880.Angel;
import faang.school.godbless.BJS218880.Creature;
import faang.school.godbless.BJS218880.Hero;
import faang.school.godbless.BJS218880.Pikeman;
import faang.school.godbless.BJS218880.Swordman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HeroTest {

    private Hero hero;

    @BeforeEach
    void setUp() {
        Map<String, Creature> creatures = new HashMap<>();
        creatures.put("Pikeman", new Pikeman(3));
        creatures.put("Angel", new Angel(5));
        creatures.put("Swordman", new Swordman(2));

        hero = new Hero("Harry", "White", 100, 5, creatures);
    }

    @Test
    void testAddingCreature() {
        Map<String, Creature> targetCreatures = new HashMap<>();
        targetCreatures.put("Pikeman", new Pikeman(10));
        targetCreatures.put("Angel", new Angel(5));
        targetCreatures.put("Swordman", new Swordman(7));

        hero.addCreature(new Pikeman(7));
        hero.addCreature(new Swordman(5));

        assertEquals(targetCreatures, hero.getCreatures());
    }

    @Test
    void testRemoveCreature() {
        Map<String, Creature> targetCreatures = new HashMap<>();
        targetCreatures.put("Angel", new Angel(1));
        targetCreatures.put("Swordman", new Swordman(2));

        hero.removeCreature(new Pikeman(3));
        hero.removeCreature(new Angel(4));

        assertEquals(targetCreatures, hero.getCreatures());
    }

    @Test
    void testAddingCreature_quantityZero() {
        assertThrows(IllegalArgumentException.class, () -> hero.addCreature(new Pikeman(0)));
    }

    @Test
    void testHeroEmptyCreatureList() {
        assertThrows(IllegalArgumentException.class, () -> new Hero("Gwen", "Black", 200, 6, new HashMap<>()));
    }


}
