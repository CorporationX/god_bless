package school.faang.lambda.bjs2_87485;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        System.out.println(spellAction.act(spellName));
    }
}