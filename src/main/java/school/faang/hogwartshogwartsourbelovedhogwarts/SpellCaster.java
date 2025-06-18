package school.faang.hogwartshogwartsourbelovedhogwarts;


public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        System.out.println(action.castSpell(spellName));
    }
}