package bjs2_33770;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast("spell1", spell -> "result of spell: " + spell);
        spellCaster.cast("spell2", spell -> "another result of spell: " + spell);
    }
}
