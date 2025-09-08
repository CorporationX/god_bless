package school.faang.bsj2_88488;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String abraKadabra = "AbraKadabra";
        String wooaLya = "WooaLya";
        String simSalabim = "SimSalabim";

        spellCaster.cast(abraKadabra, (spell) -> "Make wine from water by" + spell);
        spellCaster.cast(wooaLya, (spell) -> "Make me invisible by " + spell);
        spellCaster.cast(simSalabim, (spell) -> "Do something by " + spell);
    }
}
