package FavoriteHogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";
        String crucio = "Crucio";

        spellCaster.cast(alohomora, (spell -> "The door is unlocked by " + spell));
        spellCaster.cast(lumos, (spell -> "A beam of light is created by " + spell));
        spellCaster.cast(expelliarmus, (spell -> "The opponent is disarmed by " + spell));
        spellCaster.cast(crucio, (spell -> "Only dark wizards can use the spell " + spell + "!"));
    }
}
