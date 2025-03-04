package school.faang.task_59448;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        if (spellName == null || spellName.isBlank()) {
            throw new IllegalArgumentException("Spell name can't be null or empty");
        }
        if (spellAction == null) {
            throw new IllegalArgumentException("Spell action can't be null");
        }
        System.out.println(spellAction.doMagic(spellName));
    }
}
