package school.faang.bjs2_87357;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String fire = "Огня";
        String fireSpell = "Огненного шара";

        spellCaster.cast(fireSpell, (spell) -> fire + ", запуск большого " + spell);
    }
}
