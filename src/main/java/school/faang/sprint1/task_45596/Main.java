package school.faang.sprint1.task_45596;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast(alohomora, (spell) -> "Открытие девери " + spell);
        spellCaster.cast(lumos, (spell) -> "Фонарик " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "Обезаруживание " + spell);

    }
}
