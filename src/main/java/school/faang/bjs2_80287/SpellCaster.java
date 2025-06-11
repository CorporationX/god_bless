package school.faang.bjs2_80287;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction) {
        String result = spellAction.castSpell(spell);
        System.out.println("вы получили: " + result);
    }
}
