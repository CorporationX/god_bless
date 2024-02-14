package Lymbda.Task1;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";
        String cast = spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell);
        String cast1 = spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        String cast2 = spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
        System.out.println(cast);
        System.out.println(cast1);
        System.out.println(cast2);

    }
}
