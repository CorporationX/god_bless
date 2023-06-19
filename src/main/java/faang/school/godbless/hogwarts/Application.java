package faang.school.godbless.hogwarts;

public class Application {
    public static void main(String... args) {
        SpellCaster caster = new SpellCaster();
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        caster.cast(expelliarmus, (spell) -> "The opponent is disarmed by: " + spell);
        caster.cast(alohomora, (spell) -> "The door is unlocked by: " + spell);
        caster.cast(lumos, (spell) -> "A beam of light is created by: " + spell);
    }
}
