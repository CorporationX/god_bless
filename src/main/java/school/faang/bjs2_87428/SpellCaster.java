package school.faang.bjs2_87428;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.doAction(spellName);
        System.out.println(result);
    }
}
