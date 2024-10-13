package school.faang.bjs2_33881;

public class SpellCaster {
    public void cast(String spellName, SpellAction action) {
        validateObject(spellName, ErrorMassagesValidate.SPELL_NAME_IS_NULL);
        validateObject(action, ErrorMassagesValidate.SPELL_ACTION_IS_NULL);
        String result = action.cast(spellName);
        System.out.println(result);
    }

    private void validateObject(Object object, ErrorMassagesValidate errMessage) {
        if (object == null) {
            throw new IllegalArgumentException(errMessage.name());
        }
    }
}
