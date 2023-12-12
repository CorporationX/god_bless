package hogwarts_749;

public class Main {
    public static void main(String[] args) {
        String kadabra = "Kadabra!";
        String abra = "Abra!";
        SpellCaster caster = new SpellCaster();

        caster.cast(kadabra, (secondPart) -> "Abra " + secondPart);
        caster.cast(abra, (secondPart) -> "Abra " + secondPart);
    }
}