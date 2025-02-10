package school.faang.hogwarts.hogwarts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";
        try {
            spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
            spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
            spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
        }
    }
}
