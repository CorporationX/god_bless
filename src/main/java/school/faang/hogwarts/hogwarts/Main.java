package school.faang.hogwarts.hogwarts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final String ALOHOMORA = "Alohomora";
    private static final String LUMOS = "";
    private static final String EXPELLIARMUS = "Expelliarmus";

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        try {
            spellCaster.cast(ALOHOMORA, (spell) -> "The door is unlocked by " + spell);
        } catch (IllegalArgumentException e) {
            logger.info("There was a mistake with the spell {}.", ALOHOMORA);
        }
        try {
            spellCaster.cast(LUMOS, (spell) -> "A beam of light is created by " + spell);
        } catch (IllegalArgumentException e) {
            logger.info("There was a mistake with the spell {}.", LUMOS);
        }
        try {
            spellCaster.cast(EXPELLIARMUS, (spell) -> "The opponent is disarmed by " + spell);
        } catch (IllegalArgumentException e) {
            logger.info("There was a mistake with the spell {}.", EXPELLIARMUS);
        }
    }
}
