package task5;

public class SpellCaster {
    public void cast(String nameSpell, SpellAction spellAction){
        System.out.println(spellAction.spell(nameSpell));
    }
}
