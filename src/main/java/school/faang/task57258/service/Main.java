package school.faang.task57258.service;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String alahomora = "Alahomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";
        spellCaster.cast(alahomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos,(spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
    }
}