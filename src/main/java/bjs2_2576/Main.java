package bjs2_2576;

public class Main {
    public static void main(String[] args) {
        SpellCaster caster = new SpellCaster();
        caster.cast("Alohomora", spellName -> "The door is unlocked by " + spellName);
        caster.cast("Lumos", spellName -> "A beam of light is created by " + spellName);
        caster.cast("Expelliarmus", spellName -> "The opponent is disarmed by " + spellName);
    }
}
