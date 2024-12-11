package school.faang.bjs245536;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        String answer = spellAction.castSpell(spell);
        System.out.println(answer);
    }
}