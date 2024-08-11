package faang.school.godbless.modul2.hogwarts;

public class SpellCaster {
    public void cast(String nameCast, SpellAction spellAction) {
        System.out.println(spellAction.action(nameCast));
    }
}

