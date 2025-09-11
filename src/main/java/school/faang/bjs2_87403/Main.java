package school.faang.bjs2_87403;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String aloexplosion = "Babaha";

        spellCaster.cast(aloexplosion, (spell) -> "The door is blown up using by " + spell);
    }
}
