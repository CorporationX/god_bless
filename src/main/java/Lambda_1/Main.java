package Lambda_1;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alahomora = "Alahomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        System.out.println(spellCaster.cast(alahomora, (spell) -> "The door is unlocked by " + spell));
        System.out.println(spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell));
        System.out.println(spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell));
    }
}
