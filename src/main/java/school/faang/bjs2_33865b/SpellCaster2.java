package school.faang.bjs2_33865b;

public class SpellCaster2 implements SpellAction2 {
    @Override
    public String execute(String spellName) {
        return "You have cast the spell; " + spellName;
    }


    public String cast(String spellName) {
        return execute(spellName);
    }

}