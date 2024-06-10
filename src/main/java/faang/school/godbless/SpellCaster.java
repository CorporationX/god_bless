package faang.school.godbless;

@FunctionalInterface
interface SpellAction{
    String perform(String spellName);
}

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.perform(spellName);
        System.out.println(result);
    }
}




