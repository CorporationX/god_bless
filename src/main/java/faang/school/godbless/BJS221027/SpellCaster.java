package faang.school.godbless.BJS221027;

public class SpellCaster {
    public final String alohomora = "Alohomora Minima";
    public final String lumos = "Lumos Maxima";
    public final String expelliarmus = "Expelliarmus, Avada Kedavra";
    public void cast(String spell, SpellAction action) {
        String result = action.cast(spell);
        System.out.println(result);
    }
}
