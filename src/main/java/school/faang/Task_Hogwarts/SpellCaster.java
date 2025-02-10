package school.faang.Task_Hogwarts;

public class SpellCaster {

    public void castSpell(String spellName, SpellAction action) {

        validateSpellName(spellName);

        String result = action.castSpell(spellName);
        System.out.println("Result spell: " + result);
    }

    public void validateSpellName(String spellName) {
        if (spellName == null || spellName.isBlank()) {
            throw new IllegalArgumentException("Incorrect data entered!");
        }
    }
}