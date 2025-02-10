package school.faang.task57258.service;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.castSpell(spellName);
        System.out.println("Результат заклинания: " + result);
    }
}
