package school.faang.task_59635;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static final String ALOHOMORA = "Alohomora";
    public static final String LUMOS = "Lumos";
    public static final String EXPELLIARMUS = "Expelliarmus";

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String[] spells = {ALOHOMORA, LUMOS, EXPELLIARMUS};
        for (String spell : spells) {
            try {
                spellCaster.cast(spell, (spellName) -> "The opponent is disarmed by " + spellName);
            } catch (IllegalArgumentException e) {
                log.info("Error casting spell '{}': {}", spell, e.getMessage());
            }
        }

        try {
            spellCaster.cast(null, (spell) -> "The opponent is disarmed by " + spell);
        } catch (IllegalArgumentException e) {
            log.info("Error using null value: {}", e.getMessage());
        }
    }
}
