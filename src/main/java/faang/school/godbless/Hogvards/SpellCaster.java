package faang.school.godbless.Hogvards;
public class SpellCaster {
    public String cast(String spell, SpellAction act){
        System.out.println(act.cast(spell));
        return spell;
    }
}
