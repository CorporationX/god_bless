package faang.school.godbless;

public class SpellCaster {

    @FunctionalInterface
    interface SpellAction {
        String perform(String spell);
    }

    public void cast(String spell, SpellAction spellAction){
        String result=spellAction.perform(spell);
        System.out.println(result);
    }
}
