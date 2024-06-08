package BJS2_9130;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String spellAndAction = action.execute(spellName);
        System.out.println(spellAndAction);
    }
}