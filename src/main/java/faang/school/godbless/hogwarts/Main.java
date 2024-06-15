package faang.school.godbless.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String alhomora = "Alhomora";
        String lumos = "Lumos";
        String expeliarmus = "Expeliarmus";

        System.out.println(spellCaster.cast(alhomora, (spell) -> "Open the unlocked door by " + spell));
        System.out.println(spellCaster.cast(lumos,(spell)-> "A beam of light is created by " + spell));
        System.out.println(spellCaster.cast(expeliarmus, (spell) -> "The opponent is disarmed by" + spell));
    }
}
