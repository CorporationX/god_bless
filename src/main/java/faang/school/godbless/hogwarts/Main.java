package faang.school.godbless.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster firstCaster = new SpellCaster();
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        firstCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        firstCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        firstCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
    }
}
