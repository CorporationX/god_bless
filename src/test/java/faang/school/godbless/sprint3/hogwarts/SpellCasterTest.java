package faang.school.godbless.sprint3.hogwarts;

import faang.school.godbless.sprint3.hogwarts.SpellCaster;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpellCasterTest {
    @Test
    public void castAlohomora() {
        SpellCaster spellCaster = new SpellCaster();
        String alohomora = "Alohomora";
        assertEquals("The door is unlocked by Alohomora",
                spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell));
    }

    @Test
    public void castLumos() {
        SpellCaster spellCaster = new SpellCaster();
        String lumos = "Lumos";
        assertEquals("A beam of light is created by Lumos",
                spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell));
    }

    @Test
    public void castExpelliarmus() {
        SpellCaster spellCaster = new SpellCaster();
        String expelliarmus = "Expelliarmus";
        assertEquals("The opponent is disarmed by Expelliarmus",
                spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell));
    }
}
