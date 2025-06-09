package school.faang.hogwarts;

public class SpellCaster {
    public void cast(String name, SpellAction spellAction) {
        String result = spellAction.action(name);
        System.out.println(result);
    }
}
