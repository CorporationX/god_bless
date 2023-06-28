package faang.school.godbless;

public class SpellCaster {
    public static void main(String[] args) {
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";
        cast(alohomora, nameOfTheSpell -> "The door is unlocked by " + nameOfTheSpell);
        cast(lumos, (nameOfTheSpell) -> "A beam of light is created by " + nameOfTheSpell);
        cast(expelliarmus, nameOfTheSpell -> "The opponent is disarmed by " + nameOfTheSpell);

    }
    public static void cast(String nameOfTheSpell, SpellAction spellAction) {
        System.out.println(spellAction.action(nameOfTheSpell));
    }
}
