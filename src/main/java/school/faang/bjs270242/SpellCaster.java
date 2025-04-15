package school.faang.bjs270242;

public class SpellCaster {
    public void cast(String name, SpellAction spell) {
        String spellResult = spell.spellAction(name);
        System.out.println(spellResult);
    }
}
