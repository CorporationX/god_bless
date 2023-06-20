package faang.school.godbless.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelearmus";

        System.out.println(spellCaster.cast(alohomora, spell -> "The door is unlocked by " + spell));
        System.out.println(spellCaster.cast(lumos, spell -> "A beam of light is created by " + spell));
        System.out.println(spellCaster.cast(expelliarmus, spell -> "The opponent is disarmed " + spell));
    }
}
