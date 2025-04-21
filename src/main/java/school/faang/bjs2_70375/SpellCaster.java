package school.faang.bjs2_70375;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        String spellActionResult = spellAction.doAction(spellName);
        System.out.println(spellActionResult);
    }
}
