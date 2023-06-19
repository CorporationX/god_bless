package faang.school.godbless;

public class SpellCaster {
    public void cast(String name, SpellAction<String> function) {
        System.out.println(function.execute(name));
    }

    public static void main(String... args) {
        SpellCaster spellCaster = new SpellCaster();
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
    }
}
