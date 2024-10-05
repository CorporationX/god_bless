package dima.evseenko.heroes;

import dima.evseenko.heroes.entity.Pikeman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeroTest {

    @Test
    void addCreature() {
        Hero hero = new Hero("Dima", Fraction.PEOPLE, 1, 1);
        hero.addCreature(new Pikeman("Pikeman"), 2);

        assertEquals(new Pikeman("Pikeman"), hero.getArmy().get(0));
        assertEquals(2, hero.getArmy().size());
    }

    @Test
    void addInvalidCreature() {
        Hero hero = new Hero("Dima", Fraction.PEOPLE, 1, 1);
        hero.addCreature(null, 0);

        assertEquals(0, hero.getArmy().size());
    }

    @Test
    void deleteCreature() {
        Hero hero = new Hero("Dima", Fraction.PEOPLE, 1, 1);
        hero.addCreature(new Pikeman("Pikeman"), 2);
        hero.deleteCreature(new Pikeman("Pikeman"), 1);

        assertEquals(1, hero.getArmy().size());
    }
}