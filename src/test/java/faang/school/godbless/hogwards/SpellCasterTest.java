package faang.school.godbless.hogwards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellCasterTest {
    @Test
    void testCast() {
        SpellCaster spellCaster = new SpellCaster();
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";
        String actionWhenAlohomora = "The door is unlocked by ";
        String actionWhenlumos = "A beam of light is created by ";
        String actionWhenExpelliarmus = "The opponent is disarmed by ";

        assertAll(
                () -> assertEquals(
                        actionWhenAlohomora + alohomora,
                        spellCaster.cast(alohomora, (spell) -> actionWhenAlohomora + spell)
                ),
                () -> assertEquals(
                        actionWhenlumos + lumos,
                        spellCaster.cast(lumos, (spell) -> actionWhenlumos + spell)
                ),
                () -> assertEquals(
                        actionWhenExpelliarmus + expelliarmus,
                        spellCaster.cast(expelliarmus, (spell) -> actionWhenExpelliarmus + spell)
                )
        );
    }

}