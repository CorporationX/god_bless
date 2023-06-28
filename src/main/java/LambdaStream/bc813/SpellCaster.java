package LambdaStream.bc813;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.spell(spell));
    }
}