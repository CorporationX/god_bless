package school.faang.bjs2_80246;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        String action = spellAction.creatingSpell(spellName);
        System.out.println(" Spell caster action: " + action);
    }
}
