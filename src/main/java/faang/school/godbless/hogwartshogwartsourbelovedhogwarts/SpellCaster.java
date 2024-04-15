package faang.school.godbless.hogwartshogwartsourbelovedhogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        String resultOfSpellAction = spellAction.act(spellName);

        System.out.println(resultOfSpellAction);
    }
}
