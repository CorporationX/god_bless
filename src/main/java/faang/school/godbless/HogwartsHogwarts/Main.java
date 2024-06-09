package faang.school.godbless.HogwartsHogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> " Заклинание " + spell);
        spellCaster.cast(lumos, (spell) -> " Заклинание " + spell);
        spellCaster.cast(expelliarmus, (spell) -> " Заклинание " + spell);

    }
}
