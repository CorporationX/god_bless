package school.faang.bjs2_70499;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String stringSpell = "Sim-salyabim";
        String mediumSpell = "Abrakadabra";
        String weakSpell = "Puff";

        spellCaster.cast(weakSpell, (spell) -> "The weak Spell " + spell + " does not do much.");
        spellCaster.cast(mediumSpell, spell -> "The medium spell " + spell + " was not that bad.");
        spellCaster.cast(stringSpell, (spell -> {
            String endString = " is killing it!";
            return "The strong spell " + spell + endString;
        }));
    }
}
