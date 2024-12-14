package school.faang.sprint_2.task_45655;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String avada = "AAAVADA KEDAVRAAA!!!!!";
        String vengardium = "Vengardiu, laviosa";
        String expelliarmus = "Expecto Patronuum";

        spellCaster.cast(avada, (spell) -> "Death Garry Potter by " + spell);
        spellCaster.cast(vengardium, (spell) -> "Levitation by " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "Light by " + spell);
    }
}
