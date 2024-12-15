package school.faang.task_45605;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String alohomoraDescription = "The door is unlocked by ";
        String lumos = "Lumos";
        String lumosDescription = "A beam of light is created by ";
        String expelliarmus = "Expelliarmus";
        String expelliarmusDescription = "The opponent is disarmed by ";
        String vulneraSanentur = "Vulnera Sanentur";
        String vulneraSanenturDescription = "The person healed by ";
        String avadakedavra = "Avadakedavra";
        String avadakedavraDescription = "The opponent killed by ";

        spellCaster.cast(alohomora, (spell) -> alohomoraDescription + spell);
        spellCaster.cast(lumos, (spell) -> lumosDescription + spell);
        spellCaster.cast(expelliarmus, (spell) -> expelliarmusDescription + spell);
        spellCaster.cast(vulneraSanentur, (spell) -> vulneraSanenturDescription + spell);
        spellCaster.cast(avadakedavra, (spell) -> avadakedavraDescription + spell);
    }
}
