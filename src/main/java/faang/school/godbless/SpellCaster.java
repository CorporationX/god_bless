package faang.school.godbless;

public class SpellCaster {
    void cast(String nameOfSpell, SpellAction spellAction) {
        System.out.println(spellAction.action(nameOfSpell));
    }
}