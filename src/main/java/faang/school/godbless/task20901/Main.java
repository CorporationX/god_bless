package faang.school.godbless.task20901;

public class Main {
    public static void main(String[] args) {
    SpellAction alohomora = spell -> spell + " Дверь открыта!";
    SpellCaster spellCaster = new SpellCaster();
    spellCaster.cast("Alohomora", alohomora);
    }
}
