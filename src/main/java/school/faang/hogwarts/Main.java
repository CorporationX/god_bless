package school.faang.hogwarts;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    private static final String ALOHOMORA = "Alohomora";
    private static final String LUMOS = "Lumos";
    private static final String EXPELLIARMUS = "Expelliarmus";

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        try {
            spellCaster.cast(ALOHOMORA, (spell) -> " The door is unlocked by " + spell);
            spellCaster.cast(LUMOS, (spell) -> " A beam of light is created by " + spell);
            spellCaster.cast(EXPELLIARMUS, (spell) -> " The opponent is disarmed by " + spell);
        } catch (IllegalArgumentException e) {
            log.info(e.getMessage());
        }
    }
}