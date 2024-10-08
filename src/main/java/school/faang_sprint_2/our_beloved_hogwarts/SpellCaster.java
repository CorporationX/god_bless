package school.faang_sprint_2.our_beloved_hogwarts;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.cast(spell));
    }
}
