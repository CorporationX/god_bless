package school.faang;

public class SpellCaster {
    public void cast(String spellName, SpellAction action){
        String result = action.perform(spellName);
        System.out.println(result);
    }
}