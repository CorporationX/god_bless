package school.faang.fjs2_87546;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.castspell(spellName);
        System.out.println("Результат заклинания: " + result);
    }
}
