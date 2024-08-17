package faang.school.godbless.Hogwarts;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String alohomora = "Alohomora";
        String lumos = "Lumos";
        String expelliarmus = "Expelliarmus";

        System.out.println(spellCaster.cast(lumos, (spell) -> "Заклинание создаёт свет и называется: " + spell));
        System.out.println(spellCaster.cast(alohomora, (spell) -> "Заклинание открывает дверь и называется: " + spell));
        System.out.println(spellCaster.cast(expelliarmus, (spell) -> "Заклинание обезоруживает противника и называется: " + spell));

    }
}
