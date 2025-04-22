package school.faang.hogwarts_hogwarts;

public class Test {
    public static void main(String[] args) {

        SpellCaster spellCaster = new SpellCaster();

        String death = "Avada Kedavra";
        String levetation = "Vingardium Leviosa";
        String getObject = "Akzio";
        String openLock = "Allohomora";

        spellCaster.cast(death, ("Harry Potter was killed by %s"::formatted));
        spellCaster.cast(getObject, ("We get nimbus by %s"::formatted));
    }
}
