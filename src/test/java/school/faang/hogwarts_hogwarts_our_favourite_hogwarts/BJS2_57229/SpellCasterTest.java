package school.faang.hogwarts_hogwarts_our_favourite_hogwarts.BJS2_57229;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SpellCasterTest {

    private SpellCaster spellCaster;

    @BeforeEach
    void setUp() {
        spellCaster = new SpellCaster();
    }

    @Test
    void testCast() {
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";
        String fiendfyre = "Fiendfyre";

        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
        spellCaster.cast(fiendfyre, (spell) -> spell + " pursues its prey, burning everything in its path");
    }

    @Test
    void testCastInvalidArgument() {
        assertThrows(IllegalArgumentException.class, () ->
                spellCaster.cast("invalid", null));
        assertThrows(IllegalArgumentException.class, () ->
                spellCaster.cast(null, (spell) -> "The door is unlocked by " + spell));
        assertThrows(IllegalArgumentException.class, () ->
                spellCaster.cast("", (spell) -> "The door is unlocked by " + spell));
    }


}