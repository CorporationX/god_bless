package school.faang.lovelyhogwarts;

public class SpellCaster {

    void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.action(spellName);
        System.out.println("Применено заклинание " + result);
    }
}
