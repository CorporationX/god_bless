package heroes_of_might_and_magic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PikemanTest {

    @Test
    void getDamage() {
        Pikeman pikeman = new Pikeman("Pikeman", 5, 5, 5, 5);
        assertEquals(10, pikeman.getDamage());
    }
}