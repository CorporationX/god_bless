package school.faang.sprint_1.task_hogwardsbjs2n45519;

public class SpellCaster {
    public void cast(String inputSpell, SpellAction spellAction) {
        String result = spellAction.showSpell(inputSpell);
        System.out.println("Результат заклинания: " + result);
    }
}
