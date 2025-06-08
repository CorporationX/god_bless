package school.faang.bjs2_80173;

public class Main {
    public static void main(String[] args) {
        SpellCaster spellCaster = new SpellCaster();

        spellCaster.cast("FireBall", nameSpell -> "FireBall3000");
        spellCaster.cast("Левитация", nameSpell -> "Тут должно что-то полететь");
        spellCaster.cast("Телепортация", nameSpell -> "Ты телепортировался");
    }
}
