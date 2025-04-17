package school.faang.love_hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.println("Результат заклинания: " + result);
    }
}
