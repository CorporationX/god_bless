package faang.school.godbless;

import faang.school.godbless.units.Creature;
import faang.school.godbless.units.Griffin;
import faang.school.godbless.units.Pikeman;
import faang.school.godbless.units.Swordsman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroTest {

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FIVE = 5;
    private static final int TEN = 10;
    private static final int HUNDRED = 100;
    private static final int TWO_HUNDRED = 200;
    private static final String PIKEMAN = "pikeman";
    private static final String GRIFFIN = "Griffin";
    private static final String ORRIN = "Orrin";
    private static final String KNIGHT = "Knight";

    @Test
    void addCreature() {
        Hero heroFirst = new Hero(ORRIN, KNIGHT, HUNDRED, ONE);

        Pikeman pikeman = new Pikeman();
        Griffin griffin = new Griffin();
        Swordsman swordsman = new Swordsman();

        heroFirst.addCreature(griffin, HUNDRED);
        heroFirst.addCreature(griffin, HUNDRED);

        assertEquals(heroFirst.getCreatures().size(), ONE);

        heroFirst.addCreature(pikeman, TEN);
        assertEquals(heroFirst.getCreatures().size(), TWO);

        heroFirst.addCreature(swordsman, ONE);
        assertEquals(heroFirst.getCreatures().size(), THREE);

        Creature griffinInArmy = heroFirst.getCreatures().stream()
                .filter(c -> c.getName().equalsIgnoreCase(GRIFFIN))
                .findFirst()
                .orElse(null);

        assertEquals(griffinInArmy.getQuantity(), TWO_HUNDRED);
    }

    @Test
    void removeCreature() {
        Hero heroFirst = new Hero(ORRIN, KNIGHT, HUNDRED, ONE);

        Pikeman pikeman = new Pikeman();
        heroFirst.addCreature(pikeman, TEN);

        Creature pikemanInArmy = heroFirst.getCreatures().stream()
                .filter(c -> c.getName().equalsIgnoreCase(PIKEMAN))
                .findFirst()
                .orElse(null);

        assertEquals(pikemanInArmy.getQuantity(), TEN);

        heroFirst.removeCreature(pikeman, FIVE);

        pikemanInArmy = heroFirst.getCreatures().stream()
                .filter(c -> c.getName().equalsIgnoreCase(PIKEMAN))
                .findFirst()
                .orElse(null);
        assertEquals(pikemanInArmy.getQuantity(), FIVE);
    }

    @Test
    void testRemoveCreature() {
        Hero heroFirst = new Hero(ORRIN, KNIGHT, HUNDRED, ONE);

        Pikeman pikeman = new Pikeman();
        heroFirst.addCreature(pikeman, TEN);
    }
}