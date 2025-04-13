package lovely.hogwards;

public class Main {
    public static void main(String[] args) {
        final SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast("Alohamora", (str) -> "Door is open by " + str);
        spellCaster.cast("Getyourwallet", (str) -> "You were robbed by " + str);
        spellCaster.cast("Ovada Kedavra", (str) -> "You are killed by " + str);
    }
}
