package CendalJoe_BJS2_45727;

public class Main {

    public static void main ( String[] args ){
        SpellCaster Caster = new SpellCaster();

        String armagedon = "Armagedon";
        String chainLightning = "ChainLightning";
        String slowingDown = "SlowingDown";

        Caster.viewCast( armagedon, (spell)-> ("Armagedonus exterminato" + spell) );
        Caster.viewCast( chainLightning, (spell)-> ("Amenos chain" + spell));
        Caster.viewCast( slowingDown,(spell)-> ("Hardo walkus" + spell) );
    }
}

// Armagedon = "Armagedonus exterminato";
// ChainLightning = "Amenos chain";
// SlowingDown = "Hardo walkus";
