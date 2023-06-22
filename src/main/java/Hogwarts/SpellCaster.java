package Hogwarts;

public class SpellCaster {
    public void cast(String nameOfSpell, SpellAction spellAction){
        System.out.println(spellAction.performSpell(nameOfSpell));
    }
}
