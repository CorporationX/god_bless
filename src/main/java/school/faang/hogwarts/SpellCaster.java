package school.faang.hogwarts;

public class SpellCaster {
    public void cast(String castName, SpellAction spell) {
        String result = spell.castSpell(castName);
        System.out.println(result);
    }

    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spellName -> "1 spell is : " + alohomora));
        spellCaster.cast(lumos, (spellName -> "2 spell is : " + lumos));
        spellCaster.cast(expelliarmus, (spellName -> "3 spell is : " + spellName));
    }
}
