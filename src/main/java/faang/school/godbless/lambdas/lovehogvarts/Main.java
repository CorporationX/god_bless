package faang.school.godbless.lambdas.lovehogvarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster("Avada Kedavra");
        spellCaster.cast(spellCaster.getNameCast(), (s) -> "Использованно заклинание " + s);


    }
}
