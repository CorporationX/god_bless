package school.faang;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction, SpellEffects spellEffects) {
        String action = spellAction.action(spellName);
        String effects = spellEffects.effects(spellName);
        StringBuilder actionResult = new StringBuilder();
        actionResult.append(action).append("\n")
                    .append(spellName).append(" Effects : ").append(effects);
        System.out.println(actionResult);

    }

}
