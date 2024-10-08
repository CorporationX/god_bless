package school.faang.sprint_2.hogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction){
        System.out.println(spellAction.act(spell));
    }
}
