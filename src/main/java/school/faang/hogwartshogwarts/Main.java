package school.faang.hogwartshogwarts;

import static school.faang.hogwartshogwarts.SpellConstants.ALOHOMORA;
import static school.faang.hogwartshogwarts.SpellConstants.LUMOS;
import static school.faang.hogwartshogwarts.SpellConstants.EXPELLIARMUS;
import static school.faang.hogwartshogwarts.SpellConstants.BOMBARDA;

public class Main {
    public static void main(String[] args) {
        try {
            SpellCaster spellCaster = new SpellCaster();

            spellCaster.cast(ALOHOMORA, (spell) -> "The door is unlocked by " + spell);
            spellCaster.cast(LUMOS, (spell) -> "A beam of light is created by " + spell);
            spellCaster.cast(EXPELLIARMUS, (spell) -> "The opponent is disarmed by " + spell);
            spellCaster.cast(BOMBARDA, (spell) -> "Occurred explosion because of " + spell);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
