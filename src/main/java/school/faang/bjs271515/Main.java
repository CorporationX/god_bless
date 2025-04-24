package school.faang.bjs271515;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";
        String expectoPatronum = "Expecto Patronum";

        spellCaster.cast(alohomora, (doSpell) -> "The door is unlocked by " + doSpell);
        spellCaster.cast(lumos, (doSpell) -> "A beam of light is created by " + doSpell);
        spellCaster.cast(expelliarmus, (doSpell) -> "The opponent is disarmed by " + doSpell);
        spellCaster.cast(expectoPatronum, (doSpell) -> "Dementor can be hit by " + doSpell);
    }
}