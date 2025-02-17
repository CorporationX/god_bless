package school.faang.hogwarts_hogwarts;

public class SpellCaster {

    void cast(String castName, SpellAction spellAction) {
        System.out.println(spellAction.getSpellResult(castName));
    }
}
