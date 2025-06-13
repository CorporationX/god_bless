package school.faang.bjs2_80370;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.spell(spellName);
        System.out.println("Результат заклинания:" + result);
    }
}
