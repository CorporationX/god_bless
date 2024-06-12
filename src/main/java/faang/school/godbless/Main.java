package faang.school.godbless;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String alohorma = "Alohorma";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";
        spellCaster.cast(alohorma, (spell) -> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
    }
}
