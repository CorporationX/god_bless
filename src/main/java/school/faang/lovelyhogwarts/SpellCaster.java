package school.faang.lovelyhogwarts;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.perform(spellName);
        System.out.println("Применено заклинание " + result);
    }
}
