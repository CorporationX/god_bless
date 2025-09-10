package bjs290956;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast("Spell 1", spell -> "Action 1");
        spellCaster.cast("Spell 2", spell -> "Action 2");
        spellCaster.cast("Spell 3", spell -> "Action 3");
    }
}
