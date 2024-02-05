package faang.school.godbless.new_hogvardz;

import lombok.Data;

@Data
public class SpellCaster {

    public void cast(String spell, SpellAction action) {
    }

    public static void main(String[] args) {

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
    }
}

