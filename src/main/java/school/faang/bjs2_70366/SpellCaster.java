package school.faang.bjs2_70366;

public class SpellCaster {
    public void cast(String spellName, SpellAction action){
        String result = action.perform(spellName);
        System.out.println(result);
    }
}