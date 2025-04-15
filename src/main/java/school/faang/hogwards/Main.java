package school.faang.hogwards;

public class Main {
    public static void main(String[] args) {
        SpellCast spellCast = new SpellCast();

        spellCast.cast("Imperio", spell -> "Заклинание использовано");

        spellCast.cast("Krucio", spell -> "Большая боль");
    }
}
