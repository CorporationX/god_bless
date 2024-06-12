package faang.school.godbless.BJS29535;

public class SpellCaster {

    public String cast(String spell, SpellAction function){
       return function.apply(spell);
    }
}
