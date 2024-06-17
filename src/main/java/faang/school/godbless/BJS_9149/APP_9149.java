package faang.school.godbless.BJS_9149;

public class APP_9149 {
    public static void main(String[] args) {
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";
        System.out.println(SpellCaster.cast(alohomora, spellName -> "the door has been unlocked with " + spellName));
        System.out.println(SpellCaster.cast(lumos, spellName -> "A beam of light is created by " + spellName));
        System.out.println(SpellCaster.cast(expelliarmus, spellName -> "The opponent is disarmed by " + spellName));
    }
}