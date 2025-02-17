package school.faang.task_BJS2_57471;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {

        if (spellName == null || spellAction == null) {
            throw new IllegalArgumentException("spellName or spellAction cannot be null");
        }

        String result = spellAction.castSpell(spellName);
        System.out.println(result);
    }
}
