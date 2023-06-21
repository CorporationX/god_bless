package faang.school.godbless.sprint3.hogwarts;

public class SpellCaster {
    public void cast(String message, SpellAction action) {
        System.out.println(action.action(message));
    }
}
