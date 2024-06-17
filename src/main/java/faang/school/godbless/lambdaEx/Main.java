package faang.school.godbless.lambdaEx;

public class Main {
    public static void main(String[] args) {

        SpellCaster spellCaster = new SpellCaster();
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, spellName -> "открывает дверь");
        spellCaster.cast(lumos, spellName -> "создает свет");
        spellCaster.cast(expelliarmus, spellName -> "разоружает противника");
    }
}
