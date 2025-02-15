package school.faang.bjs2_57551;

public class SpellCaster implements SpellAction {

    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.action(spell));
    }

    @Override
    public String action(String spell) {
        return "";
    }
}
