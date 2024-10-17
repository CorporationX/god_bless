package school.faang.bjs2_33865;

public class SpellCaster implements SpellAction {
    @Override
    public String execute(String spellName) {
        return "You have cast the spell; " + spellName;
    }


    public String cast(String spellName) {
        return execute(spellName);
    }

//just coment to make push to github
}
