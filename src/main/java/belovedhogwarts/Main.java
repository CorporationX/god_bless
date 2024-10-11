package belovedhogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast("spell 1", spell -> "custom line 1 : " + spell);
        spellCaster.cast("spell 2", spell -> "custom line 2 : " + spell);
        spellCaster.cast("spell 3", spell -> "custom line 3 : " + spell);
    }
}
