package school.faang.sprint2.hogwarts;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction){
        String result = spellAction.castSpell(spellName);
        System.out.println("Результат заклинания: " + result);
    }
 }
