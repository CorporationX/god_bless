package school.faang.task_45740;

public class SpellCaster {
    public void castSpell(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.println("Spell " + spellName + " was casted: " + result);
    }
}
