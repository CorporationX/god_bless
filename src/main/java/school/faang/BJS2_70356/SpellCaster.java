package school.faang.BJS2_70356;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.castSpell(spellName);
        System.out.println("Результат: " + result);
    }
}