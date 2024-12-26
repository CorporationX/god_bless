package beloved_hogwarts;

public class Main {
    private static final SpellCaster spellCaster = new SpellCaster();

    public static void main(String[] args) {
        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";
        spellCaster.cast(lumos, (spell) -> spell + " комнату озарил свет!");
    }
}