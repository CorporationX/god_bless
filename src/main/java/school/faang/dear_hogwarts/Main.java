package school.faang.dear_hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster caster = new SpellCaster();

        String bombardo = "Bombardo";

        caster.cast(bombardo, (spellName -> spellName + " do boom!"));
    }
}
