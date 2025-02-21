package school.faang.task_59448;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.doMagic(spellName));
    }
}
