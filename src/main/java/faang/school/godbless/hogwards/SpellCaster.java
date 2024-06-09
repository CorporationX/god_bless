package faang.school.godbless.hogwards;

public class SpellCaster {

    public void cast(String nameSpell, SpellAction spellAction) {
        System.out.println(spellAction.action(nameSpell));
    }
}
