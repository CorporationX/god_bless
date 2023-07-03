package main.java.faang.school.godbless.hogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction){
        spell = spellAction.cast(spell);
        System.out.println(spell);
    }
}
