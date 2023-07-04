package Hogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction){
        spell = spellAction.spell(spell);
        System.out.println(spell);
    }
}
