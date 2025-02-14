package school.faang.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String lumos = SpellConstants.lumos;
        String expelliarmus = SpellConstants.expelliarmus;
        String blankus = SpellConstants.blankus;
        String alohomora = SpellConstants.alohomora;
        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
        spellCaster.cast(blankus, (spell) -> "The subject is erased by " + spell);
    }
}
