package faang.school.godbless.hogwards;

public class SpellCaster {

    public void cast(String spell, SpellAction action) {
        System.out.println("I wanna spell on you... " + action.cast(spell));
    }

}
