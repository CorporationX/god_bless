package faang.school.godbless.lambda.task06_hogwarts;

public class SpellCaster {
    public static void cast(String spell, SpellAction spellAction){
        String result = spellAction.spellResult(spell);
        System.out.println(result);
    }

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell)-> "The door is unlocked by " + spell);
        spellCaster.cast(lumos, (spell)-> "A beam of light is created by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "The opponent is disarmed by " + spell);
    }
}
