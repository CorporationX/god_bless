package faang.school.godbless;

import faang.school.godbless.units.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    void addCreature() {

        Hero heroFirst = new Hero("Orrin", "Knight", 100, 1);

        Pikeman pikeman = new Pikeman();
        Griffin griffin = new Griffin();
        Swordsman swordsman = new Swordsman();

        heroFirst.addCreature(griffin, 100);
        heroFirst.addCreature(griffin, 100);

        assertEquals(heroFirst.getCreatures().size(), 1);

        heroFirst.addCreature(pikeman, 10);
        assertEquals(heroFirst.getCreatures().size(), 2);

        heroFirst.addCreature(swordsman, 1);
        assertEquals(heroFirst.getCreatures().size(), 3);

        Creature griffinInArmy = heroFirst.getCreatures().stream().filter(c -> c.getName().equalsIgnoreCase("Griffin")).findFirst().orElse(null);

        assertEquals(griffinInArmy.getQuantity(), 200);

    }

    @Test
    void removeCreature() {

        Hero heroFirst = new Hero("Orrin", "Knight", 100, 1);

        Pikeman pikeman = new Pikeman();
        heroFirst.addCreature(pikeman, 10);

        Creature pikemanInArmy = heroFirst.getCreatures().stream().filter(c -> c.getName().equalsIgnoreCase("pikeman")).findFirst().orElse(null);

        assertEquals(pikemanInArmy.getQuantity(), 10);

        heroFirst.removeCreature(pikeman, 5);

        pikemanInArmy = heroFirst.getCreatures().stream().filter(c -> c.getName().equalsIgnoreCase("pikeman")).findFirst().orElse(null);
        assertEquals(pikemanInArmy.getQuantity(), 5);

    }

    @Test
    void testRemoveCreature() {

        Hero heroFirst = new Hero("Orrin", "Knight", 100, 1);

        Pikeman pikeman = new Pikeman();
        heroFirst.addCreature(pikeman, 10);

        heroFirst.removeCreature(pikeman);
        assertEquals(heroFirst.getCreatures().size(), 0);

    }
}