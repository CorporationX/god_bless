package faang.school.godbless.bjs220935;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast("Lumus", spell -> "A beam of light is created by " + spell);
        spellCaster.cast("Expelliarmus", spell -> "The opponent is disarmed by " + spell);
    }
}