package hogwarts_749;

public class Main {
    public static void main(String[] args) {
        String kadabra = "Kadabra!";
        String abra = "Abra!";
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast(kadabra, (action) -> "Abra " + action);
        spellCaster.cast(abra, (action) -> "Abra " + action);
    }
}