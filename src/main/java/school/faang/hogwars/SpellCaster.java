package school.faang.hogwars;

public class SpellCaster {
    public void cast(String nameSpell, SpellAction spellAction) {
        String result = spellAction.castSpell(nameSpell);
        System.out.println(result);
    }
}