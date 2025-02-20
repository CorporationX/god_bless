package school.faang.BJS2_59510;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();
        String lumos = "Lumos";

        spellCaster.cast(lumos, s -> "A beam of light is created by " + s);
    }
}
