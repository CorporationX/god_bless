package school.faang.functional_interfaces.bjs2_70395.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + alohomora);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + lumos);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + expelliarmus);
    }
}
