package faang.school.functionalinterfaces;

public class SpellCaster {

    public void cast(String spellName, SpellAction spellAction) {
        if (spellName != null) {
            if (spellName.isBlank()) {
                System.out.println("Произнесите заклинание!");
            } else {
                try {
                    String spell = spellAction.cast(spellName);
                    System.out.println(spell);
                } catch (NullPointerException e) {
                    System.out.println("Произнесите заклинание!");
                }
            }
        } else {
            System.out.println("Произнесите заклинание!");
        }
    }

}
