package faang.school.godbless.hogwarts;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        if (spellName == null || spellName.isEmpty()) {
            throw new IllegalArgumentException("Spell can't be empty/null.");
        }
        System.out.println("Casting spell: " + spellName + " ~~~ " + spellAction.castSpell(spellName));
    }
}
