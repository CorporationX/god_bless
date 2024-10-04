package heroes_of_might_and_magic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AngelTest {

    @Test
    void getDamage() {
        Angel angel = new Angel("Angel", 5, 5, 5, 5);
        assertEquals(25, angel.getDamage());
    }
}