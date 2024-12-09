package school.faang.sprint_2.task_45454;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String avadakedavra = "Avada Kedavra";
        String lumos = "Lumos";

        spellCaster.cast(lumos, (spellName -> "A beam of light is created by " + spellName));
        spellCaster.cast(avadakedavra, (spellName -> "Harry Potter dead by " + spellName));
    }
}
