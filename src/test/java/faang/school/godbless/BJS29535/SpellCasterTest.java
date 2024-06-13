package faang.school.godbless.BJS29535;

import org.junit.jupiter.api.Test;

class SpellCasterTest {

    @Test
    void cast() {
        SpellCaster spellCaster = new SpellCaster();

        var asd = "фывфыафывафва";

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        System.out.println(spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell));
        System.out.println(spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell));
        System.out.println(spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell));
    }
}