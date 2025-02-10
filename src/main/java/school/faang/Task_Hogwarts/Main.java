package school.faang.Task_Hogwarts;

public class Main {
    public static void main(String[] args) {

        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.castSpell(alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.castSpell(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.castSpell(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
    }
}