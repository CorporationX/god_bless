package school.faang.bjs2_70201;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.printf("result of spell: %s\n", spellAction.doAction(spellName));
    }
}