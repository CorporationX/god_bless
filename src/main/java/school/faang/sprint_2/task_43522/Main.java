package school.faang.sprint_2.task_43522;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String aguamenti = "Агуаменти";
        String accio = "Акцио";
        String confringo = "Вспыхни";

        spellCaster.cast(aguamenti, spell -> "Вода создана " + spell);
        spellCaster.cast(accio, spell -> "Предмет призван " + spell);
        spellCaster.cast(confringo, spell -> "Предмет взорван " + spell);
    }
}
