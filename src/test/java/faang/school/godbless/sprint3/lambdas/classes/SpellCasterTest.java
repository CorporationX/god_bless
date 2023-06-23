package faang.school.godbless.sprint3.lambdas.classes;

import faang.school.godbless.sprint3.lambdas.Hogwarts.classes.SpellCaster;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SpellCasterTest {
    private static SpellCaster caster;

    private static final String ALOHOMORA = "Alohomora";

    private static final String LUMOS = "Lumos";

    private static final String EXPELLIARMUS = "Expelliarmus";

    private static final String EMPTY_STRING = "";

    @BeforeAll
    static void setUp() {
        caster = new SpellCaster();
    }

    @Test
    @DisplayName("Test with Alohomora")
    void cast_testWithAlohomora() {
        String result = caster.cast(ALOHOMORA, thisSpell -> "The door is unlocked by " + thisSpell);
        assertEquals("The door is unlocked by Alohomora", result);
    }

    @Test
    @DisplayName("Test with Lumos")
    void cast_testWithLumos() {
        String result = caster.cast(LUMOS, thisSpell -> "A beam of light is created by " + thisSpell);
        assertEquals("A beam of light is created by Lumos", result);
    }


    @Test
    @DisplayName("Test with Expelliarmus")
    void cast_testWithExpelliarmus() {
        String result = caster.cast(EXPELLIARMUS, thisSpell -> "The opponent is disarmed by " + thisSpell);
        assertEquals("The opponent is disarmed by Expelliarmus", result);
    }


    @Test
    @DisplayName("Test with nullable spell")
    void cast_TestWithNullableSpell() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> caster.cast(null, thisSpell -> "Anything" + thisSpell));
        assertEquals(SpellCaster.SPELL_IS_NULL_EXCEPTION, exception.getMessage());
    }

    @Test
    @DisplayName("Test with empty spell")
    void cast_TestWithEmptySpell() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> caster.cast(EMPTY_STRING, thisSpell -> "Anything" + thisSpell));
        assertEquals(SpellCaster.SPELL_IS_EMPTY_EXCEPTION, exception.getMessage());
    }
}