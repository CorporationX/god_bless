package school.faang.lovelyhogwarts;

/**
 * @author Danil Pudovkin
 * @since 09.06.2025
 */
public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.doSpell(spellName));
    }
}
