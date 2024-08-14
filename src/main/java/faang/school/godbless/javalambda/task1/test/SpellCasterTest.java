package faang.school.godbless.javalambda.task1.test;

import faang.school.godbless.javalambda.task1.SpellCaster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpellCasterTest {
    SpellCaster spellCaster;

    @BeforeEach
    public void setUp() {
        spellCaster = new SpellCaster();
    }

    @Test
    void cast() {
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";


        assertEquals("The door is unlocked by Alohomora",
                spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell));
        assertEquals("A beam of light is created by Lumos",
                spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell));
        assertEquals("The opponent is disarmed by Expelliarmus", spellCaster.cast(expelliarmus,
                (spell) -> "The opponent is disarmed by " + spell));
    }
}