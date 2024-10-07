package school.faang.hogwards.main;

import school.faang.hogwards.maincode.SpellCaster;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell -> "The door is unloced by " + spell));
        spellCaster.cast(lumos, (spell -> "A beam of light is created by " + spell));
        spellCaster.cast(expelliarmus, (spell -> "The opponent is disarmed by " + spell));
    }
}
