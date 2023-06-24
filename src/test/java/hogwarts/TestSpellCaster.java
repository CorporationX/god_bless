package hogwarts;

import faang.school.godbless.hogwarts.SpellCaster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestSpellCaster {

    @Test
    @DisplayName("Should cast the spells")
    void shouldCastSpell() {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        String alohomoraResult = "The door is unlocked by Alohomora";
        String lumosResult = "A beam of light is created by Lumos";
        String expelliarmusResult = "The opponent is disarmed by Expelliarmus";

        Assertions.assertEquals(alohomoraResult, spellCaster.cast(alohomora, (spell) ->
                "The door is unlocked by " + spell));

        Assertions.assertEquals(lumosResult, spellCaster.cast(lumos, (spell) ->
                "A beam of light is created by " + spell));

        Assertions.assertEquals(expelliarmusResult, spellCaster.cast(expelliarmus, (spell) ->
                "The opponent is disarmed by " + spell));
    }
}
