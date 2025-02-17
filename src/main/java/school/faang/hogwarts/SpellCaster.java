package school.faang.hogwarts;

import java.util.logging.Logger;

public class SpellCaster {
    private static final String ALOHOMORE = "Alohomora";
    private static final String LUMOS = "Lumos";
    private static final String EXPELLIARMUS = "Expelliarmus";

    private static final Logger log = Logger.getLogger(SpellCaster.class.getName());

    public void cast(String spellName, SpellAction action) {
        if ((spellName == null) && action == null) {
            log.warning("Поле не может быть пустым");
            return;
        }

        String result = action.castSpell(spellName);
        System.out.println("Результат заклинания: " + result);
    }

    public static void main(String[] args) {

        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast(ALOHOMORE, spell -> "The door is unlocked by " + spell);
        spellCaster.cast(LUMOS, spell -> "A beam of light is created by " + spell);
        spellCaster.cast(EXPELLIARMUS, spell -> "The opponent is disarmed by " + spell);
    }
}