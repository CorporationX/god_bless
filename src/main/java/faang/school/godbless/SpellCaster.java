package faang.school.godbless;

public class SpellCaster {

    public void cast(String spellText, SpellAction spellAction) {
        String result = spellAction.cast(spellText);
        System.out.println(result);
    }
}
