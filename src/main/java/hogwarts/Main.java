package hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Алохамора";
        String lumos = "Люмос";
        String expelliarmus = "Экспелиармус";

        spellCaster.cast(alohomora, (action) -> "дверь открыта заклинанием " + action);
        spellCaster.cast(lumos, (action) -> "свет создан заклинанием " + action);
        spellCaster.cast(expelliarmus, (action) -> "противник разоружен заклинанием " + action);
    }
}
