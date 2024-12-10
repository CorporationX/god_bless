package school.faang.task_45566;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        String result = spellAction.cast(spell);

        System.out.println("Result: " + result);
    }
}
