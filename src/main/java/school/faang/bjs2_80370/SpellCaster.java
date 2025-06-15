package school.faang.bjs2_80370;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.spellCast(spellName);
        System.out.println("Заклинание: " + result);
    }
}
