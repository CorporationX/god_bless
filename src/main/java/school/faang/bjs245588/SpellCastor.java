package school.faang.bjs245588;

public class SpellCastor {
    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.action(spellName);
        System.out.println(result);
    }
}
