package faang.school.godbless.BJS2_20933;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> "Дверь открывается заклинанием " + spell);
        spellCaster.cast(lumos, (spell) -> "Заклинание " + spell + " создает свет");
        spellCaster.cast(expelliarmus, (spell) -> "Противник разоружен заклинанием " + spell);
    }
}
