package faang.school.godbless.hogwards;

public class SpellCaster {
    public void cast(String string, SpellAction action) {
        System.out.println(action.action(string));
    }
}
