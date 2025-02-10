package school.faang.hogwarts_hogwarts_our_favourite_hogwarts.BJS2_57229;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpellCasterTest {

    private SpellCaster spellCaster;

    @BeforeEach
    void setUp() {
        spellCaster = new SpellCaster();
    }

    @Test
    void cast() {
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
    }
}