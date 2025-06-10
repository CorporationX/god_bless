package school.faang.dear_hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        System.out.println(action.perform(spellName));
    }
}
