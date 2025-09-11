package school.faang.bjs2_87428;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.action(spellName);
        System.out.println(result);
    }
}
