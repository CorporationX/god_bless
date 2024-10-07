package school.faang.Hogwarts;

public class SpellCaster {
    public void cast(String cast, SpellAction spellAction) {
        String result = spellAction.perform(cast);
        System.out.println(result);
    }
}