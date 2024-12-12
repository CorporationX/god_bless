package ru.maks1979.task_45564;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.action(spellName));

    }
}
