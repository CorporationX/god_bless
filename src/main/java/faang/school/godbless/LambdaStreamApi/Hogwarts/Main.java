package faang.school.godbless.LambdaStreamApi.Hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast("Алохомора", (spellName) -> spellName + ": дверь отперта");
        spellCaster.cast("Люмус", (spell) -> spell + ": свет зажжён");
        spellCaster.cast("Экспелиармус", (spellName) -> spellName + ": противник обезоружен");
    }
}
