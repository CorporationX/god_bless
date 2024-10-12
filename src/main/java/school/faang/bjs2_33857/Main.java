package school.faang.bjs2_33857;

public class Main {

    public static void main(String[] args) {
        String patronus = "Patronus";
        String lumus = "Lumos";

        SpellCaster spellCaster = new SpellCaster();
        spellCaster.castSpell(patronus, (spell -> "Protection from demons by " + spell));
        spellCaster.castSpell(lumus, spell -> "A beam of light is created by " + spell);
    }

}
