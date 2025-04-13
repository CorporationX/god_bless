package school.faang.hogwarts.spell.management;

public class SpellCaster {

    public void cast(String nameSpell, SpellAction spellAction) {
        String result = spellAction.castSpell(nameSpell);
        System.out.println(result);
    }
}
