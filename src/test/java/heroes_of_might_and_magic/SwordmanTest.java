package heroes_of_might_and_magic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwordmanTest {

    @Test
    void getDamage() {
        Swordman swordman = new Swordman("Swordman", 5, 5, 5, 5);
        assertEquals(20, swordman.getDamage());
    }
}