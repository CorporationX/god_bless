package heroes_of_might_and_magic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GriffinTest {

    @Test
    void getDamage() {
        Griffin griffin = new Griffin("Griffin", 5, 5, 5, 5);
        assertEquals(15, griffin.getDamage());
    }
}