package school.faang.sprint2task45647;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAct) {
        String result = spellAct.castSpell(spellName);
        System.out.println("Результат заклинания: " + result);
    }
}