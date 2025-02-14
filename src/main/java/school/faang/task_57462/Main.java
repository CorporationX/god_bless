package school.faang.task_57462;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, spellTitle -> "The door is unlocked by " + spellTitle);
        spellCaster.cast(lumos, spellTitle -> "A beam of light is created by " + spellTitle);
        spellCaster.cast(expelliarmus, spellTitle -> "The opponent is disarmed by " + spellTitle);
    }
}
