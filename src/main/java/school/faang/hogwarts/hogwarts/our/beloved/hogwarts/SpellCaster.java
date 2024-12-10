package school.faang.hogwarts.hogwarts.our.beloved.hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.spell(spellName);
        System.out.println(result);
    }
}

