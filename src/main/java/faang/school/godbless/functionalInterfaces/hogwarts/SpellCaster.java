package faang.school.godbless.functionalInterfaces.hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        if(spellName == null || spellName.isBlank()) {
            System.out.println("Nothing happened.");

            return;
        }

        System.out.println(spellAction.getSpellResult(spellName));
    }
}
