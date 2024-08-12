package faang.school.godbless.BJS_20809;

public class SpellCaster{
    public void cast(String spell, SpellAction spellAction){
        String result = spellAction.getSpell(spell);
        System.out.println(result);
    }
}
