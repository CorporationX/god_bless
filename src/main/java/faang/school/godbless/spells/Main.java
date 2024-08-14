package faang.school.godbless.spells;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> String.format("%s! You've opened the door!", spell));
        spellCaster.cast(lumos, (spell) -> String.format("%s! You've created a light!", spell));
        spellCaster.cast(expelliarmus, (spell) -> String.format("%s! You've disarmed your opponent!", spell));
    }
}
