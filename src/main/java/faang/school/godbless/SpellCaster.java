package faang.school.godbless;
public class SpellCaster {
    String cast(String spell, SpellAction spellAction) {
        return spellAction.cast(spell);
    }


    public static void main(String[] args) {

        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        System.out.println(spellCaster.cast(alohomora, (spell) -> "The door is unlocked by " + spell));
        System.out.println(spellCaster.cast(lumos, (spell) -> "A beam of light is created by " + spell));
        System.out.println(spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell));
    }
}