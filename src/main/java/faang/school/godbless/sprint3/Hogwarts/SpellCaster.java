package faang.school.godbless.sprint3.Hogwarts;

public class SpellCaster {
    public void cast (String spell, SpellAction spellAction) {
        if (spell == null || spell.isEmpty())
            throw new IllegalArgumentException("Empty spell");
        System.out.println(spell + ": " + spellAction.spellAct(spell));
    }
}
