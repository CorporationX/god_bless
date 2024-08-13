package faang.school.godbless.secondsprint.hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        if(spellName == null || spellName.isEmpty()) {
            System.out.println("No spell has been cast");
        } else {
            System.out.println(action.perform(spellName));
        }
    }
}
