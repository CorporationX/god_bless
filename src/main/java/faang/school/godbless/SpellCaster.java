package faang.school.godbless;

public class SpellCaster {
    public void cast(String str, SpellAction spellAction){
        System.out.println(spellAction.spellMethod(str));
    }

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (string) -> "The door is unlocked by " + string);
        spellCaster.cast(lumos, (string) -> "A beam of light is created by " + string);
        spellCaster.cast(expelliarmus, (string) -> "The opponent is disarmed by " + string);
    }
}
