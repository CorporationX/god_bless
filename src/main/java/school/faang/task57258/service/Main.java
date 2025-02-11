package school.faang.task57258.service;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        try {
            spellCaster.cast(spellCaster.getAlahomora(), (spell) -> "The door is unlocked by " + spell);
            spellCaster.cast(spellCaster.getLumos(), (spell) -> "A beam of light is created by " + spell);
            spellCaster.cast(spellCaster.getExpelliarmus(), (spell) -> "The opponent is disarmed by " + spell);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }
}