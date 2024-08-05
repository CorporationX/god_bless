package faang.school.functionalinterfaces;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        String spell = spellAction.cast(spellName);
        System.out.println(spell);
    }

}
