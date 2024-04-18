package faang.school.godbless.InterfacesLambda.HogwartsOurFavorite;

public class SpellCaster {

    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.performSpell(spell));
    }
}
