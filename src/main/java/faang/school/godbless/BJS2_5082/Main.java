package faang.school.godbless.BJS2_5082;

public class Main {
    public static void main(String[] args){
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spellName) -> " открыло дверь");
        spellCaster.cast(lumos, (spellName) -> " создало свет");
        spellCaster.cast(expelliarmus, (spellName) -> " разоружило противника");
    }
}
