package bjs2_33393;

public class Main {

    public static void main(String[] args) {
        SpellCaster spellCaster =  new SpellCaster();

        spellCaster.cast("Alohomora", (spellName) -> "The door is closed by " + spellName);
        spellCaster.cast("Lumos", (spellName) -> "A beam of light is created by " + spellName);
        spellCaster.cast("Expelliarmus", (spellName) -> "The opponent is disarmed by " + spellName);
    }
}
