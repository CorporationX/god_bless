package src.main.java.faang.school.godbless;

public class SpellCaste {
    void cast(String spellName, SpellAction spellAction) {
        String result = spellAction.spell(spellName);
        System.out.println(result);
    }


    public static void main(String[] args) {
        SpellCaste spellCaster = new SpellCaste();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);

    }
}
