package school.faang.bjs2_80370;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        String ignis = "Ignis";
        String auro = "Auro";
        String lumous = "Lumous";

        spellCaster.cast(ignis, spellName -> "Поджигает рядом с вами стоящие деревья");
        spellCaster.cast(auro, spellName -> "Поднимает легкий предмет в воздух");
        spellCaster.cast(lumous, spellName -> "Ваша палочка начинает ярко сиять");
    }
}
