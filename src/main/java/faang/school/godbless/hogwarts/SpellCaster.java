package faang.school.godbless.hogwarts;

public class SpellCaster {
    public static void cast(String spell, SpellAction spellAction) {
        System.out.println(spellAction.getSpell(spell));
    }

    public static void main(String[] args) {
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        cast(alohomora, (spell -> "The door is unlocked by " + spell));
        cast(lumos, (spell -> "A beam of light is created by " + spell));
        cast(expelliarmus, (spell -> "The opponent is disarmed by " + spell));
    }
}
