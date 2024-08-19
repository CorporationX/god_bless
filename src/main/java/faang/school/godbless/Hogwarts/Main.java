package faang.school.godbless.Hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        spellCaster.cast("Алохомора",spellName -> spellName + "Дверь откройся!");
        spellCaster.cast("Люмос",spellName -> spellName + "Включился свет!");
        spellCaster.cast("Экспелиармус",spellName -> spellName + "Разоружение!");
    }
}
