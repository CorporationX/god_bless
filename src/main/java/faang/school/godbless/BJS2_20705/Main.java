package faang.school.godbless.BJS2_20705;

public class Main {
    public static void main(String[] args) {
        SpellCaster garry = new SpellCaster();
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        garry.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        garry.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        garry.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
    }
}
