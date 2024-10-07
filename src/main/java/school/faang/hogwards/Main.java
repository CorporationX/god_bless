package school.faang.hogwards;

public class Main {
    public static void main(String[] args) {
        SpellCaster caster = new SpellCaster();
        caster.cast("Alohomora", spell -> "The door is unlocked by " + spell);
        caster.cast("Lumos", spell -> "A beam of light is created by " + spell);
        caster.cast("Заклинание Амаяка", spell -> "Сим салабим рахат лукум - " + spell);
    }
}
