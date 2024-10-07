package school.faang.hogwarts;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.cast(spellName);
        System.out.println(result);
    }
}


