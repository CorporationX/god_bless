package faang.school.functionalinterfaces;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        if (spellName == null || spellName.isBlank()) {
            System.out.println("Введите название заклинания!");
        } else {
            if (spellAction == null) {
                System.out.println("Произнесите заклинание!");
            } else {
                String spell = spellAction.cast(spellName);
                System.out.println(spell);
            }
        }
    }
}

