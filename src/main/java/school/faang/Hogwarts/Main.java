package school.faang.Hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster caster = new SpellCaster();

        String expelliarmus = "Expelliarmus";
        String alohomora = "Alohomora";
        caster.cast(expelliarmus, (spellName -> "The opponent is disarmed by " + spellName));
        caster.cast(alohomora, spellName -> "The door is unlocked by " + spellName);
    }
}
