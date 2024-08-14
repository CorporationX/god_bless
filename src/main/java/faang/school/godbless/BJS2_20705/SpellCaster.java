package faang.school.godbless.BJS2_20705;

public class SpellCaster {

    public void cast(String spell, SpellAction action){
        if(spell == null){
            throw new IllegalArgumentException("Spell is not chosen");
        }
        if(action == null){
            throw new IllegalArgumentException("Action is not chosen");
        }
        System.out.println(action.describeSpell(spell));
    }
}
