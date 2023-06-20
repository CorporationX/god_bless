package faang.school.godbless.secondSprint.Hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast("bombarda", spellName -> "Благодоря " + spellName + " вы смогли cпасти Сириуса");
        spellCaster.cast("leviosa", spellName -> "С помощью " + spellName + " вы подняли троля в воздух");
        spellCaster.cast("crucio", spellName -> "Применив " + spellName + " вы заставили оппонента страдать");
    }
}
