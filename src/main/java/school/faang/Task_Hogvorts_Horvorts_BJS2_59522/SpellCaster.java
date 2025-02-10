package school.faang.Task_Hogvorts_Horvorts_BJS2_59522;

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