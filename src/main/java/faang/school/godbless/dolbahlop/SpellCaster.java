package faang.school.godbless.dolbahlop;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.act(spell));
    }
}
