package school.faang.bjs2_80370;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String lumous = "Lumous";
        String patronum = "Patronum";
        String electrum = "Electrum";

        spellCaster.cast(lumous, (spell) -> " Создал источник света с помощью" + spell);
        spellCaster.cast(patronum, (spell -> " Метнул зарядом магии при помощи" + spell));
        spellCaster.cast(electrum, (spell -> " Создает электрический заряд с помощью " + spell));
    }
}
