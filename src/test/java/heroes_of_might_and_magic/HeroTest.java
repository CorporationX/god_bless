package heroes_of_might_and_magic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {
    static final Hero FIRST_HERO = new Hero("John", "Theif", 1, 5);

    @BeforeEach
    void setUp() {
        FIRST_HERO.addCreature(new Pikeman("Pikeman", 5, 5, 5, 5), 5);
    }

    @AfterEach
    void tearDown() {
        FIRST_HERO.getArmy().clear();
    }

    @Test
    void addCreature() {
        FIRST_HERO.addCreature(new Pikeman("Angel", 5, 5, 5, 5), 5);
        assertEquals(5, FIRST_HERO.getArmy().get(new Pikeman("Angel", 5, 5, 5, 5)));
    }

    @Test
    void removeCreature() {
        FIRST_HERO.removeCreature(new Pikeman("Angel", 5, 5, 5, 5), 5);
        assertNull(FIRST_HERO.getArmy().get(new Pikeman("Angel", 5, 5, 5, 5)));
    }
}