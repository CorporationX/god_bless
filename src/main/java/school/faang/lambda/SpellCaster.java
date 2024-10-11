package school.faang.lambda;

public class SpellCaster {
    public String cast(String phraseSC, SpellAction spellAction){
        return spellAction.transferPhraseToAction(phraseSC);
    }
}