package hogwarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Алохомора";
        String lumos = "Люмос";
        String expelliarmus = "Экспеллиармус";

        System.out.println("Позвольте преподать вам колдовские штучки!\n");

        spellCaster.cast(alohomora, (spell) -> "Дверь была открыта с помощью заклинания " + spell);
        spellCaster.cast(lumos, (spell) -> "Луч света был создан с помощью заклинания " + spell);
        spellCaster.cast(expelliarmus, (spell) -> "Противник обезоружен с помощью заклинания " + spell);
    }
}
