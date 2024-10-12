package BJS2_33861;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast("Воскресни", (spell) -> System.out.println("Герой оживлен заклинанием " + spell));
    }
}
