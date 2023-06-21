package faang.school.godbless.hogwarts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellCasterTest {

    @Test
    void testCast() {
        String excepted1 = "Object opened by Alohamora";
        String excepted2 = "A beam of light is created by Lumos";
        String excepted3 = "The opponent is disarmed by Expelliarmus";

        String actual1 = SpellCaster.cast("Alohamora", spell -> "Object opened by " + spell);
        String actual2 = SpellCaster.cast("Lumos", (spell) -> "A beam of light is created by " + spell);
        String actual3 = SpellCaster.cast("Expelliarmus", (spell) -> "The opponent is disarmed by " + spell);

        assertEquals(excepted1, actual1);
        assertEquals(excepted2, actual2);
        assertEquals(excepted3, actual3);
    }
}