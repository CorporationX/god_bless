package school.faang.stream2.ourbelovedhogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        String result = action.makeItHappened(spellName);
        System.out.println(result);
    }
}
