package faang.school.godbless.hogwarts;

import java.util.List;

public class SpellCaster {
    private final String alohomora = "Alohomora";
    private final String lumos = "Lumos";
    public void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.add(spell));
    }
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast(spellCaster.alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(spellCaster.lumos, (spell) -> "The opponent is disarmed by " + spell);
    }
}
