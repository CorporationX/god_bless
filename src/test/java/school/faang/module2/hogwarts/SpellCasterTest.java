package school.faang.module2.hogwarts;

import org.junit.jupiter.api.Test;

class SpellCasterTest {

    @Test
    void testCast() {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by %s".formatted(spell));
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by %s".formatted(spell));
        spellCaster.cast(expelliarmus, "The opponent is disarmed by %s"::formatted);

    }

}