package faang.school.godbless.BJS221027;

public class App {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast(spellCaster.alohomora, (spell) -> "Unlocking charm: " + spell);
        spellCaster.cast(spellCaster.lumos, (spell) -> "Light charm maxima: " + spell);
    }
}
