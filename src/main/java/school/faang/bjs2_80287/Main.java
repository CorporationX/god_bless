package school.faang.bjs2_80287;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String spellBoom = "brrrshalaBOOM";

        spellCaster.cast(spellBoom, spell -> "возможность пройти дарк соулс 3 с помощью магии а именно " + spell);
    }
}
