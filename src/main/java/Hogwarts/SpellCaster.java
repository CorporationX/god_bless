package Hogwarts;

public class SpellCaster {
    public void cast(String spell, SpellAction spellAction){
        String result = spellAction.cast(spell);
        System.out.println(result);
    }

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";
        String avada = "Avada";

        spellCaster.cast(alohomora, (s1 -> "The door is unlocked by " + s1));
        spellCaster.cast(lumos, s1 -> "A beam of light is created by " + s1);
        spellCaster.cast(expelliarmus, s1 -> "The opponent is disarmed by " + s1);
    }
}
