package faang.school.godbless.love.hogvarts;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster("Avada Kedavra");
        spellCaster.cast(spellCaster.getNameCast(), (s) -> "Использованно заклинание " + s);


    }
}
