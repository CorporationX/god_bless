package faang.school.godbless.hogwartsHogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction action) {
        String result = action.spellAction(spell);
        System.out.println("Результат выполнения заклинания " + spell + ":" + result);
    }

    @FunctionalInterface
    interface SpellAction {
        String spellAction(String spell);
    }
}