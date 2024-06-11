package faang.school.godbless.module1.sprint2.task2;

public class SpellCaster {
    public void cast(String spell,SpellAction<String> spellAction) {
        String result = spellAction.castSpell(spell);
        System.out.println(result);
    }
}
