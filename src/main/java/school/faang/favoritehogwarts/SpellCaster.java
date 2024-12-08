package school.faang.favoritehogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.cast(spellName);
        System.out.println(result);
    }
}
