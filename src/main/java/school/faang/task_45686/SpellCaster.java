package school.faang.task_45686;

public class SpellCaster {
    public void cast(String nameSpell, SpellAction spellAction) {
        String result = spellAction.castSpell(nameSpell);
        System.out.println("Заклинание выполнено. Результат заклинания: " + result);
    }
}
