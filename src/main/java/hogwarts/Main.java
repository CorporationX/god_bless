package hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String alohomora = "alohomora";
        String lumos = "lumos";
        String expelliarmus = "expelliarmus";

        spellCaster.cast(alohomora, (String nameSpell) -> { return "Активировано заклинание " + nameSpell; });
        spellCaster.cast(lumos, (String nameSpell) -> { return "Активировано заклинание " + nameSpell; });
        spellCaster.cast(expelliarmus, (String nameSpell) -> { return "Активировано заклинание " + nameSpell; });

    }

}
