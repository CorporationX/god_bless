package school.faang.task_45727;

public class Main {

    public static void main(String[] args) {
        SpellCaster casterWatch = new SpellCaster();

        String armagedon = "Armagedon";
        String chainLightning = "ChainLightning";
        String slowingDown = "SlowingDown";

        casterWatch.viewCast(armagedon, spell -> "Armagedonus exterminato - " + spell);
        casterWatch.viewCast(chainLightning, spell -> "Amenos chain - " + spell);
        casterWatch.viewCast(slowingDown, spell -> "Hardo walkus - " + spell);
    }
}
