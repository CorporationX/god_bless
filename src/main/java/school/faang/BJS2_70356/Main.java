package school.faang.BJS2_70356;

public interface Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        spellCaster.cast("Alohomora", (spell) -> String.format("The door is unlocked by %s", spell));
        spellCaster.cast("Lumos", (spell) -> String.format("A beam of light is created by %s", spell));
        spellCaster.cast("Expelliarmus", (spell) -> String.format("The opponent is disarmed by %s", spell));
    }
}