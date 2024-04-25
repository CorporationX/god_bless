package faang.school.godbless.hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster caster = new SpellCaster();
        SpellAction alohomora = spellName -> "Door unlocked!";
        SpellAction lumos = spellName -> "Light created!";
        SpellAction expelliarmus = spellName -> "Enemy disarmed!";

        caster.cast("Alohomora", alohomora);
        caster.cast("Lumos", lumos);
        caster.cast("Expelliarmus", expelliarmus);
    }
}
