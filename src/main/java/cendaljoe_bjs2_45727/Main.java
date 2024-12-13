package cendaljoe_bjs2_45727;

public class Main {

    public static void main(String[] args) {
        SpellCaster CasterWatch = new SpellCaster();

        String armagedon = "Armagedon";
        String chainLightning = "ChainLightning";
        String slowingDown = "SlowingDown";

        CasterWatch.viewCast(armagedon, spell -> "Armagedonus exterminato - " + spell);
        CasterWatch.viewCast(chainLightning, spell -> "Amenos chain - " + spell);
        CasterWatch.viewCast(slowingDown, spell -> "Hardo walkus - " + spell);
    }
}
