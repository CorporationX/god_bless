package faang.school.godbless.functionalInterfaces.hogwarts;

public class SpellCaster {
    public void cast(String spellName, SpellAction spellAction) {
        if(spellName == null || spellName.isBlank()) {
            System.out.println("Cast system cannot perform casting without spell name!");

            return;
        }

        System.out.println(spellAction.getSpellResult(spellName));
    }
}
