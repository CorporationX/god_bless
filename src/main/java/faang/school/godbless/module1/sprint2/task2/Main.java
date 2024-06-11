package faang.school.godbless.module1.sprint2.task2;

public class Main {
    public static void main(String[] args) {
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";
        String ultima = "Ultima";
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast(alohomora,(spellAction) -> "The door is unlocked by " + spellAction);
        spellCaster.cast(lumos,(spellAction) -> "A beam of light is created by" + spellAction);
        spellCaster.cast(expelliarmus,(spellAction) -> "The opponent is disarmed by " + spellAction);
        spellCaster.cast(ultima,(spellAction) -> "12334 " + spellAction);
    }
}
